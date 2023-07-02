package com.furama.config;

import com.furama.util.LocalDateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {
    private String pattern = "yyyy-MM-dd";

    @Bean
    LocalDateFormatter localDateFormatter() {
        return new LocalDateFormatter(pattern);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(localDateFormatter());
    }
}
