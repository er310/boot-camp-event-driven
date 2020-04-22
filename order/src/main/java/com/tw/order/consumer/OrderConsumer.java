package com.tw.order.consumer;

import com.tw.library.dto.CostumeDto;
import com.tw.library.dto.OrderDto;
import com.tw.library.exception.ErrorCode;
import com.tw.library.exception.JmsBrokerException;
import com.tw.library.model.JmsServiceCode;
import com.tw.order.entity.Order;
import com.tw.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderConsumer implements MessageListener {

    private final OrderService service;
    private static final String destination = JmsServiceCode.Constants.QUEUE_ORDER_COSTUME;

    @Autowired
    public OrderConsumer(OrderService service) {
        this.service = service;
    }

    @JmsListener(destination = destination)
    public void receiveMessage(@Payload OrderDto dto) {
        this.service.create(dto);
    }

    @Override
    public void onMessage(Message message) {
        if (!(message instanceof CostumeDto)) {
            throw new JmsBrokerException("JmsBroker: failed to cast "
                    + CostumeDto.class
                    + " as an input.",
                    ErrorCode.JMS_EXCEPTION);
        }
    }
}