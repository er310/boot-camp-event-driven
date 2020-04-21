package com.tw.library.config;

import com.tw.library.converter.ZonedDateTimeReadConverter;
import com.tw.library.converter.ZonedDateTimeWriteConverter;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public abstract class MongoBasicConfig {

    public List<Converter<?, ?>> getConversions() {
        final List<Converter<?, ?>> converters = new ArrayList<>();

        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());

        return converters;
    }
}
