package com.tw.backend.config;

import com.tw.library.model.JmsServiceCode;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.ConnectionFactory;
import java.text.MessageFormat;

@Configuration
@EnableJms
public class JmsConfig {
    @Value("${jms.broker.url}")
    private String broker;

    @Value("${jms.broker.username}")
    private String username;

    @Value("${jms.broker.password}")
    private String password;

    private String topicName = JmsServiceCode.TOPIC_BACKEND.getValue();
    private String queueName = JmsServiceCode.QUEUE_BACKEND.getValue();

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsConfig.class);

    public JmsConfig() {
        LOGGER.info("Initializing: " + JmsConfig.class);
    }

    /**
     * ActiveMQ implementation for connection factory. If you want to use other
     * messaging engine,you have to implement it here. In this
     * case,ActiveMQConnectionFactory.
     *
     * @return ConnectionFactory - JMS interface
     **/
    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(broker);
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);
        connectionFactory.setTrustAllPackages(true);

        return connectionFactory;
    }

    /**
     * Catching connection factory for better performance if big load
     *
     * @return ConnectionFactory - cachingConnection
     **/
    @Bean("cachingConnectionFactory")
    public ConnectionFactory cachingConnectionFactory(@Qualifier("connectionFactory") ConnectionFactory factory) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setTargetConnectionFactory(factory);
        connectionFactory.setSessionCacheSize(10);

        return connectionFactory;
    }

    /**
     * Sender configuration for topic
     *
     * @return JmsTemplate
     * @see JmsTemplate
     */
    @Bean(name = "jmsTemplateTopic")
    public JmsTemplate jmsTemplateTopic(@Qualifier("connectionFactory") ConnectionFactory factory) {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(factory);
        template.setDefaultDestinationName(topicName);
        template.setPubSubDomain(true);

        return template;
    }

    /**
     * Sender configuration for queue
     *
     * @return JmsTemplate
     * @see JmsTemplate
     */
    @Primary
    @Bean(name = "jmsTemplateQueue")
    public JmsTemplate jmsTemplateQueue(@Qualifier("connectionFactory") ConnectionFactory factory) {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(factory);
        template.setDefaultDestinationName(queueName);
        template.setPubSubDomain(false);

        return template;
    }

    /**
     * Jms Listener
     *
     * @param factory
     * @return DefaultJmsListenerContainerFactory
     */
    @Bean(name = "jmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(@Qualifier("connectionFactory") ConnectionFactory factory) {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(factory);
        defaultJmsListenerContainerFactory.setConcurrency("3-10");
        defaultJmsListenerContainerFactory.setErrorHandler(
                t -> LOGGER.error("Listening: an error has occurred in the transaction. Message: "
                        + t.getCause().getMessage()));

        return defaultJmsListenerContainerFactory;
    }

    /**
     * Serialize message content to json using TextMessage
     *
     * @return MessageConverter
     */
    @Bean("jacksonJmsMessageConverter")
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");

        return converter;
    }

    /**
     * ThreadPool for long executions
     *
     * @return ThreadPoolTaskExecutor
     * @see ThreadPoolTaskExecutor
     */
    @Bean
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor ex = new ThreadPoolTaskExecutor();
        ex.setCorePoolSize(5);
        ex.setMaxPoolSize(15);

        return ex;
    }
}
