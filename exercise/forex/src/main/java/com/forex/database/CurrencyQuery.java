package com.forex.database;

public class CurrencyQuery {
    public static final String SELECT_MONEY =
            "SELECT * FROM money";

    public static final String SEARCH_MONEY =
            "SELECT * FROM money WHERE id = ?";
}
