package com.furama.util;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    private String dateTimePattern;
    private DateTimeFormatter dateTimeFormatter;

    public LocalDateTimeFormatter(String dateTimePattern) {
        this.dateTimePattern = dateTimePattern;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
    }

    public String getDateTimePattern() {
        return dateTimePattern;
    }

    public void setDateTimePattern(String dateTimePattern) {
        this.dateTimePattern = dateTimePattern;
    }

    @Override
    public LocalDateTime parse(String dateTimeString, Locale locale) throws ParseException {
        try {
            return LocalDateTime.parse(dateTimeString, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String print(LocalDateTime dateTime, Locale locale) {
        return dateTime.format(dateTimeFormatter);
    }
}
