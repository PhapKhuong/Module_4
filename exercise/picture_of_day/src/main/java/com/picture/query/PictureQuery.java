package com.picture.query;

public class PictureQuery {
    private PictureQuery() {
    }

    public static final String FIND_BY_DATE = "SELECT * FROM fb WHERE initDate = CURDATE()";
}
