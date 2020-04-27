package com.tw.amazon.controller;

import com.tw.amazon.service.ProductService;
import com.tw.library.amazon.ProductResponse;
import com.tw.library.data.Result;
import com.tw.library.dto.OrderDto;
import com.tw.library.model.OrderChannelCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class AmazonWebHookController {
    
    private ProductService service;

    @Autowired
    public AmazonWebHookController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "/web-hook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Result<Boolean> create(@RequestBody ProductResponse dto) {
        this.service.webHook(
                new OrderDto(dto.getRefNo(), OrderChannelCode.AMAZON, dto.getStatus()));

        return new Result<>(true);
    }
}
