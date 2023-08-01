package com.furama.regex;

public class FRegex {
    private FRegex() {
    }

    // KH-XXXX
    public static final String REGEX_CUSTOMER_ID = "^KH-[\\d]{4}$";
    // DV-XXXX
    public static final String REGEX_SERVICE_ID = "^DV-[\\d]{4}$";
    // 090xxxxxxx || 091xxxxxxx || (84)+90xxxxxxx || (84)+91xxxxxxx
    public static final String REGEX_PHONE = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$";
    // CMND (9 || 12)
    public static final String REGEX_ID_NUMBER = "^([\\d]{9}|[\\d]{12})$";
    // Email
    public static final String REGEX_EMAIL = "^[\\w.]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}$";
    // Date
    public static final String REGEX_DATE = "dd/MM/yyyy";
}
