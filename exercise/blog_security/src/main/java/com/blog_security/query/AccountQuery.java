package com.blog_security.query;

public class AccountQuery {
    private AccountQuery() {
    }
    public static final String SELECT_USER_BY_ID =
            "SELECT * FROM app_user WHERE username = :username";
    public static final String SELECT_USER_ROLE_BY_ID =
            "SELECT r.role_name FROM user_role ur INNER JOIN app_role r ON ur.role_id = r.role_id WHERE ur.username = :ur.username";
    public static final String INSERT_USER_ROLE =
            "INSERT INTO user_role (role_id, username) VALUE (:role_id, :username)";
}
