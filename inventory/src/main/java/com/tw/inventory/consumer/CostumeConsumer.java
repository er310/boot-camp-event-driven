package com.tw.inventory.consumer;

import com.tw.inventory.service.CostumeService;
import com.tw.library.dto.CostumeDto;
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
public class CostumeConsumer implements MessageListener {

    private CostumeService service;
    private static final String destination = JmsServiceCode.Constants.QUEUE_INVENTORY_COSTUME;

    @Autowired
    public CostumeConsumer(CostumeService service) {
        this.service = service;
    }

    @JmsListener(destination = destination)
    public void receiveMessage(@Payload CostumeDto dto) {
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
