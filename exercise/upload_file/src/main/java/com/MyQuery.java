package com;

public class MyQuery {

    private MyQuery() {
    }

    public static final String UPDATE_USER =
            "UPDATE user SET fullName = ?, code = ?, birthday = ?, initTime = ? WHERE userId = ?";
    public static final String DELETE_ACC =
            "DELETE FROM account WHERE userId = ?";
    public static final String DELETE_USER =
            "DELETE FROM user WHERE userId = ?";
    public static final String CREATE_USER =
            "INSERT INTO user (userId, fullName, code, birthday, initTime) VALUE (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_USER =
            "SELECT *\n" +
                    "FROM (account INNER JOIN user ON account.userId = user.userId)\n" +
                    "INNER JOIN role ON account.roleId = role.roleId";
    public static final String SEARCH_TYPE_BY_ID =
            "SELECT * FROM music_type WHERE typeId = ?";
    public static final String SELECT_ALL_TYPE =
            "SELECT * FROM music_type";
    public static final String INSERT_NEW_SONG =
            "INSERT INTO song (sId, name, singer, typeId, file) VALUE (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_SONG =
            "SELECT * FROM (song INNER JIN music_type ON song.typeId = music_type.typeId)";

    public static final String CREATE_ACC =
            "INSERT INTO account (userId, roleId) VALUE (?, ?)";
    public static final String SEARCH_USER =
            "SELECT *\n" +
                    "FROM (account INNER JOIN user ON account.userId = user.userId)\n" +
                    "INNER JOIN role ON account.roleId = role.roleId\n" +
                    "WHERE fullName LIKE ?";


    public static final String SEARCH_BOOK =
            "SELECT * FROM book WHERE bookName LIKE ? AND author LIKE ?";
}
