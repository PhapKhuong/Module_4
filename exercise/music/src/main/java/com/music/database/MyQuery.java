package com.music.database;

public class MyQuery {

    private MyQuery() {
    }

    public static final String SEARCH_TYPE_BY_ID =
            "SELECT * FROM music_type WHERE typeId = ?";
    public static final String SELECT_ALL_TYPE =
            "SELECT * FROM music_type";
    public static final String INSERT_NEW_SONG =
            "INSERT INTO song (sId, name, singer, typeId, file) VALUE (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_SONG =
            "SELECT * FROM (song INNER JIN music_type ON song.typeId = music_type.typeId)";
}
