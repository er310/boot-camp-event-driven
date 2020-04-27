package com.tw.fakeamazon.controller;

import com.tw.library.amazon.ProductResponse;
import com.tw.library.amazon.ProductWebHook;
import com.tw.library.data.Result;
import com.tw.library.amazon.ProductRequest;
import com.tw.library.model.SellStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Value("${amazon.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public ProductController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/web-hook/{refNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<Boolean> getById(@PathVariable String refNo) {
        ProductWebHook productWebHook = new ProductWebHook(refNo, SellStatus.SOLD);

        ResponseEntity<String> response = this.restTemplate.postForEntity(
                baseUrl + "/products/web-hook", productWebHook, String.class);
        if (response.getStatusCodeValue() == 200) {
            return new Result<>(true);
        }

        return new Result<>(false);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<ProductResponse> create(@RequestBody ProductRequest dto) {
        return new Result<>(new ProductResponse(dto.getRefNo(), SellStatus.SELL));
    }
}