package com.tw.amazon.service.impl;

import com.tw.amazon.entity.Product;
import com.tw.amazon.repository.ProductRepository;
import com.tw.amazon.helper.JmsProducer;
import com.tw.amazon.service.AbstractService;
import com.tw.amazon.service.ProductService;
import com.tw.library.data.Result;
import com.tw.library.data.Status;
import com.tw.library.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<Product, Long> implements ProductService {

    private final ProductRepository repository;
    private final JmsProducer jmsProducer;

    @Autowired
    public ProductServiceImpl(final ProductRepository repository, final JmsProducer jmsProducer) {
        this.repository = repository;
        this.jmsProducer = jmsProducer;
    }

    @Override
    protected CrudRepository<Product, Long> getRepository() {
        return repository;
    }

    @Override
    public Result<OrderDto> create(OrderDto dto) {
        Result<OrderDto> result;

        try {
            result = new Result<>(dto);
        } catch (Exception e) {
            result = new Result<>(Status.FAIL, e.getMessage());
        }

        return result;
    }
}