package com.tw.inventory.consumer;

import com.tw.inventory.entity.Costume;
import com.tw.inventory.service.CostumeService;
import com.tw.library.model.JmsServiceCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.Message;
import javax.jms.MessageListener;

public class CostumeConsumer implements MessageListener {

    private CostumeService service;
    private static final String destination = JmsServiceCode.QUEUE_INVENTORY_COSTUME.getValue();

    @Autowired
    public CostumeConsumer(CostumeService service) {
        this.service = service;
    }

    @JmsListener(destination = "this.destination")
    public void receiveMessage(Costume costume) {
        this.service.create(costume);
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof Costume) {
            Costume costume = ((Costume) message);
        } else {
        }
    }
}
