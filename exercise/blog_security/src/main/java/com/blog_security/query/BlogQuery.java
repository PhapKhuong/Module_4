package com.blog_security.query;

public class BlogQuery {
    private BlogQuery() {
    }

    public static final String SELECT_ALL_BLOG =
            "SELECT * FROM blog INNER JOIN category ON blog.category_id = category.category_id ORDER BY blog.date";

    public static final String SELECT_BLOG_BY_ID =
            "SELECT * FROM blog INNER JOIN category ON blog.category_id = category.category_id WHERE id = :id ORDER BY blog.date";

    public static final String SELECT_BLOG_BY_CATEGORY =
            "SELECT * FROM blog INNER JOIN category ON blog.category_id = category.category_id WHERE blog.category_id = :blog.category_id";
}