package com.library.config;

import com.library.util.LocalDateFormatter;
import com.library.util.LocalDateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {
    private String datePattern = "yyyy-MM-dd";
    private String dateTimePattern = "yyyy-MM-dd HH:mm:ss";

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
