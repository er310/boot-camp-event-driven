package com.tw.order.service.impl;

import com.tw.order.entity.Order;
import com.tw.order.repository.OrderRepository;
import com.tw.order.service.AbstractService;
import com.tw.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order, Long> implements OrderService {

    protected final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Order, Long> getRepository() {
        return repository;
    }

    @Override
    public Order create(Order book) {
        return repository.save(book);
    }
}