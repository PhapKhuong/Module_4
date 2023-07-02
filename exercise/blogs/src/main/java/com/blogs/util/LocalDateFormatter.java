package com.blogs.util;

import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    private String pattern;
    private DateTimeFormatter formatter;

    public LocalDateFormatter(String datePattern) {
        this.pattern = datePattern;
        this.formatter = DateTimeFormatter.ofPattern(datePattern);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public LocalDate parse(String dateString, Locale locale) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        return date.format(formatter);
    }
}
