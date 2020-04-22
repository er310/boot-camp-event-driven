package com.tw.order.service.impl;

import com.tw.library.data.Result;
import com.tw.library.data.Status;
import com.tw.library.dto.CostumeDto;
import com.tw.library.dto.OrderDto;
import com.tw.library.model.Condition;
import com.tw.library.model.JmsServiceCode;
import com.tw.library.model.OrderChannelCode;
import com.tw.order.entity.Order;
import com.tw.order.helper.JmsProducer;
import com.tw.order.repository.OrderRepository;
import com.tw.order.service.AbstractService;
import com.tw.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends AbstractService<Order, Long> implements OrderService {

    private final OrderRepository repository;
    private final JmsProducer jmsProducer;

    @Autowired
    public OrderServiceImpl(final OrderRepository repository, final JmsProducer jmsProducer) {
        this.repository = repository;
        this.jmsProducer = jmsProducer;
    }

    @Override
    protected CrudRepository<Order, Long> getRepository() {
        return repository;
    }

    @Override
    public Result<OrderDto> create(OrderDto dto) {
        Result<OrderDto> result;
        if (dto == null || dto.getCostumeDto() == null)
            return new Result<>(Status.FAIL, "OrderDto input was empty.");

        try {
            Order order = new Order();
            Condition condition = dto.getCostumeDto().getCondition();
            if (condition == Condition.NEW || condition == Condition.LIKE_NEW)
                order.setChannelCode(OrderChannelCode.AMAZON);
            else if (condition == Condition.USED)
                order.setChannelCode(OrderChannelCode.EBAY);

            OrderDto orderDto = new OrderDto(dto.getCostumeDto(),
                    order.getRefNo(),
                    order.getChannelCode(),
                    order.getAssignmentDateTime());
            Order order1 = repository.save(order);
            if (order1 != null) {
                if (order1.getChannelCode() == OrderChannelCode.AMAZON)
                    this.jmsProducer.convertAndSend(JmsServiceCode.QUEUE_AMAZON_ORDER, orderDto);
                else if (order1.getChannelCode() == OrderChannelCode.EBAY)
                    this.jmsProducer.convertAndSend(JmsServiceCode.QUEUE_EBAY_ORDER, orderDto);
            }

            result = new Result<>(orderDto);
        } catch (Exception e) {
            result = new Result<>(Status.FAIL, e.getMessage());
        }

        return result;
    }
}