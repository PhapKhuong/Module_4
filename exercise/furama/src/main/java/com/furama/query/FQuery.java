package com.furama.query;

public class FQuery {
    private FQuery() {
    }

    public static final String SELECT_ALL_CUSTOMER =
            "SELECT * FROM customer INNER JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id";

}
