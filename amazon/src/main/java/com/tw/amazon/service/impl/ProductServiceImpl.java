package com.tw.amazon.service.impl;

import com.tw.amazon.entity.Product;
import com.tw.amazon.helper.JmsProducer;
import com.tw.amazon.repository.ProductRepository;
import com.tw.amazon.service.AbstractService;
import com.tw.amazon.service.ProductService;
import com.tw.library.amazon.ProductResponse;
import com.tw.library.data.Result;
import com.tw.library.data.Status;
import com.tw.library.dto.OrderDto;
import com.tw.library.amazon.ProductRequest;
import com.tw.library.model.JmsServiceCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class ProductServiceImpl extends AbstractService<Product, Long> implements ProductService {

    @Value("fake-amazon.url")
    private String baseUrl;

    private final ProductRepository repository;
    private final JmsProducer jmsProducer;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(final ProductRepository repository,
                              final JmsProducer jmsProducer,
                              final RestTemplate restTemplate) {
        this.repository = repository;
        this.jmsProducer = jmsProducer;
        this.restTemplate = restTemplate;
    }

    @Override
    protected CrudRepository<Product, Long> getRepository() {
        return repository;
    }

    @Override
    public Result<OrderDto> create(OrderDto dto) {
        Result<OrderDto> result;

        try {
            Product product = new Product(dto.getCostumeDto().getCostumeId(), dto.getCostumeDto().getCondition());

            Product product1 = repository.insert(product);
            if (product1 != null) {
                ProductRequest productRequest = new ProductRequest(
                        product.getRefNo(),
                        product.getCondition(),
                        product.getDescription()
                );

                ResponseEntity<ProductResponse> response = this.restTemplate.postForEntity(
                        baseUrl + "/products", productRequest, ProductResponse.class);
                if (response.getStatusCodeValue() == 200) {
                    product1.setIsPublished(true);
                    product1.setStatus(response.getBody().getStatus());

                    repository.save(product1);
                }
            }

            result = new Result<>(dto);
        } catch (Exception e) {
            result = new Result<>(Status.FAIL, e.getMessage());
        }

        return result;
    }

    @Override
    public Result<OrderDto> webHook(OrderDto dto) {
        Result<OrderDto> result;

        try {
            Product product = new Product();
            product.setRefNo(dto.getRefNo());
            Example<Product> example = Example.of(product, ExampleMatcher.matchingAny());

            Product product1 = repository.findOne(example).orElse(null);
            if (product1 != null) {
                product1.setStatus(dto.getStatus());
                repository.save(product);

                this.jmsProducer.convertAndSend(JmsServiceCode.QUEUE_SELL_ORDER, dto);
            }

            result = new Result<>(dto);
        } catch (Exception e) {
            result = new Result<>(Status.FAIL, e.getMessage());
        }

        return result;
    }
}