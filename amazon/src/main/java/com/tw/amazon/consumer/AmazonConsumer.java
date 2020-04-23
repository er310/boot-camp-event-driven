package com.tw.amazon.consumer;

import com.tw.amazon.service.ProductService;
import com.tw.library.dto.OrderDto;
import com.tw.library.exception.ErrorCode;
import com.tw.library.exception.JmsBrokerException;
import com.tw.library.model.JmsServiceCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class AmazonConsumer implements MessageListener {

    private ProductService service;
    private static final String destination = JmsServiceCode.Constants.QUEUE_AMAZON_ORDER;

    @Autowired
    public AmazonConsumer(ProductService service) {
        this.service = service;
    }

    @JmsListener(destination = destination)
    public void receiveMessage(@Payload OrderDto dto) {
        this.service.create(dto);
    }

    @Override
    public void onMessage(Message message) {
        if (!(message instanceof OrderDto)) {
            throw new JmsBrokerException("JmsBroker: failed to cast "
                    + OrderDto.class
                    + " as an input.",
                    ErrorCode.JMS_EXCEPTION);
        }
    }
}
