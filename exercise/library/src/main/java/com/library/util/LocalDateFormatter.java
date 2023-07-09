package com.library.util;

import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    private String datePattern;
    private DateTimeFormatter dateFormatter;

    public LocalDateFormatter(String datePattern) {
        this.datePattern = datePattern;
        this.dateFormatter = DateTimeFormatter.ofPattern(datePattern);
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public LocalDate parse(String dateString, Locale locale) {
        try {
            return LocalDate.parse(dateString, dateFormatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        return date.format(dateFormatter);
    }
}
