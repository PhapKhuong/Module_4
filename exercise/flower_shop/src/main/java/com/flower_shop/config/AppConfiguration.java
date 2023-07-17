package com.flower_shop.config;

import com.flower_shop.util.LocalDateFormatter;
import com.flower_shop.util.LocalDateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {
    @Value("${upload}")
    private String fileUpload;

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

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSizePerFile(50 * 1024 * 1024);
        return commonsMultipartResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(localDateFormatter());
        registry.addFormatter(localDateTimeFormatter());
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + fileUpload);
    }
}