package com.tw.order.service;

import com.tw.order.entity.Order;

public interface OrderService extends BaseService<Order, Long> {
    Order create(Order order);
}