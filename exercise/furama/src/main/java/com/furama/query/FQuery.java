package com.furama.query;

public class FQuery {
    private FQuery() {
    }

    public static final String SELECT_ALL_CUSTOMER =
            "SELECT * FROM customer c INNER JOIN customer_type ct ON c.customer_type_id = ct.customer_type_id WHERE customer_name LIKE :customer_name";

    public static final String INSERT_CUSTOMER =
            "insert into customer (customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)\n" +
                    "value (:customer_type_id, :customer_name, :customer_birthday, :customer_gender, :customer_id_card, :customer_phone, :customer_email, :customer_address);";

    public static final String SELECT_ALL_EMPLOYEE =
            "SELECT e.* FROM (((((employee e INNER JOIN position p ON e.position_id = p.position_id)" +
                    "INNER JOIN education_degree ed ON e.education_degree_id = ed.education_degree_id) INNER JOIN division d ON e.division_id = d.division_id) INNER JOIN user u ON e.username = u.username) INNER JOIN user_role ur ON u.username = ur.username) INNER JOIN role r ON ur.role_id = r.role_id WHERE employee_name LIKE :employee_name";
}
