package com.blog_rest.config;

import com.blog_rest.util.LocalDateFormatter;
import com.blog_rest.util.LocalDateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {
    private String pattern = "yyyy-MM-dd";
    private String dateTimePattern = "yyyy-MM-dd HH:mm:ss";

    @Bean
    LocalDateFormatter localDateFormatter() {
        return new LocalDateFormatter(pattern);
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
