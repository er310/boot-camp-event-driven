package com.tw.order.config;

import com.tw.library.config.JmsBasic;
import com.tw.library.model.JmsServiceCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class JmsConfig extends JmsBasic {

    private final static String topicName = JmsServiceCode.TOPIC_ORDER.getValue();
    private final static String queueName = JmsServiceCode.QUEUE_ORDER.getValue();

    public JmsConfig(@Value("${jms.broker.url}") String broker,
                     @Value("${jms.broker.username}") String username,
                     @Value("${jms.broker.password}") String password) {
        super(broker, username, password, topicName, queueName);
    }
}
