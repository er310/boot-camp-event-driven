package com.tw.amazon.service;

import com.tw.amazon.entity.Product;
import com.tw.library.data.Result;
import com.tw.library.dto.OrderDto;

public interface ProductService extends BaseService<Product, Long> {
    Result<OrderDto> create(OrderDto dto);
}