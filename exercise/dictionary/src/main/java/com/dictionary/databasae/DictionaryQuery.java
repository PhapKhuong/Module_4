package com.dictionary.databasae;

public class DictionaryQuery {
    private DictionaryQuery() {
    }

    public static final String SEARCH_BY_E =
            "SELECT * FROM ev WHERE e = ?";

    public static final String SEARCH_BY_V =
            "SELECT * FROM ev WHERE v = ?";
}
