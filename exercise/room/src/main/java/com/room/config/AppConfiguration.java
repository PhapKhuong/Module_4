package com.room.config;

import com.room.util.LocalDateFormatter;
import com.room.util.LocalDateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {
    private String datePattern = "dd-MM-yyyy";
    private String dateTimePattern = "dd-MM-yyyy HH:mm:ss";

    @Bean
    LocalDateFormatter localDateFormatter() {
        return new LocalDateFormatter(datePattern);
    }

    @Bean
    LocalDateTimeFormatter localDateTimeFormatter() {
        return new LocalDateTimeFormatter(dateTimePattern);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(localDateFormatter());
        registry.addFormatter(localDateTimeFormatter());
    }
}
