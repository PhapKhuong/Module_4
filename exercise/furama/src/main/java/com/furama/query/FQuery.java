package com.furama.query;

public class FQuery {
    private FQuery() {
    }

    public static final String SELECT_ALL_CUSTOMER =
            "SELECT * FROM customer INNER JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id";

    public static final String INSERT_CUSTOMER =
            "insert into customer (customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)\n" +
                    "value (:customer_type_id, :customer_name, :customer_birthday, :customer_gender, :customer_id_card, :customer_phone, :customer_email, :customer_address);";

}
