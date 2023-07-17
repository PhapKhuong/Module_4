package com.flower_shop.query;

public class FlowerQuery {
    private FlowerQuery() {
    }

    public static final String SELECT_ALL_FLOWER_PAGE_BY_NAME =
            "SELECT * FROM flower WHERE flower_name LIKE :flower_name";

    public static final String SELECT_ALL_FLOWER =
            "SELECT * FROM flower";
}
