package com.tw.library.helper;

import com.tw.library.exception.ErrorCode;
import com.tw.library.exception.JmsBrokerException;
import com.tw.library.model.JmsServiceCode;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;

public abstract class JmsBasicProducer {

    private final JmsTemplate jmsTemplate;

    public JmsBasicProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void convertAndSend(JmsServiceCode jmsServiceCode, Object o) {
        if (this.jmsTemplate == null)
            throw new JmsBrokerException("JmsBroker: failed to find template.", ErrorCode.JMS_EXCEPTION);

        try {
            this.jmsTemplate.convertAndSend(jmsServiceCode.getValue(), o);
        } catch (JmsException e) {
            throw new JmsBrokerException("JmsBroker: failed.", ErrorCode.JMS_EXCEPTION);
        }
    }
}