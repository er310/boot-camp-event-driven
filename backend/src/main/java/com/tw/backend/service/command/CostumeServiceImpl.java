package com.tw.backend.service.command;

import com.tw.backend.dto.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class CostumeServiceImpl implements CostumeService {
    private JmsTemplate jmsTemplate;

    @Autowired

    public CostumeServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Costume sendMessage(Costume costume) {
        try {
            jmsTemplate.convertAndSend(costume);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return costume;
    }
}
