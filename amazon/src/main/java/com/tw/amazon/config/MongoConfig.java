package com.tw.amazon.config;

import com.tw.library.config.MongoBasic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class MongoConfig extends MongoBasic {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(this.getConversions());
    }
}
