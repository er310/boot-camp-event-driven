package com.tw.amazon.helper;

import com.tw.library.helper.JmsBasicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer extends JmsBasicProducer {

    @Autowired
    public JmsProducer(JmsTemplate jmsTemplate) {
        super(jmsTemplate);
    }
}
