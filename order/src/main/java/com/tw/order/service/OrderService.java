package com.tw.order.service;

import com.tw.library.data.Result;
import com.tw.library.dto.OrderDto;
import com.tw.order.entity.Order;

public interface OrderService extends BaseService<Order, Long> {
    Result<OrderDto> create(OrderDto dto);
}