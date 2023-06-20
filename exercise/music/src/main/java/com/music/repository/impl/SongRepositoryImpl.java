package com.music.repository.impl;

import com.music.database.DBConnection;
import com.music.database.MyQuery;
import com.music.model.MusicType;
import com.music.model.Song;
import com.music.repository.itf.ISongRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SongRepositoryImpl implements ISongRepository {
    @Value("${file-upload}")
    private String fileUpload;

    @Override
    public Map<Song, String> showList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Map<Song, String> songMap = new HashMap<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SELECT_ALL_SONG);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int sId = resultSet.getInt("sId");
                    String name = resultSet.getString("name");
                    String singer = resultSet.getString("singer");

                    int typeId = resultSet.getInt("typeId");
                    String type = resultSet.getString("type");
                    MusicType musicType = new MusicType(typeId, type);

                    Blob blob = resultSet.getBlob("file");
                    byte[] byteArr = blob.getBytes(1, (int) blob.length());
                    File file = new File(fileUpload + name + ".mp4");
                    FileCopyUtils.copy(byteArr, file);
                    String path = "/download/" + name + ".mp4";

                    Song song = new Song(sId, name, singer, musicType);
                    songMap.put(song, path);
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return songMap;
    }

    @Override
    public void add(Song song) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.INSERT_NEW_SONG);
                statement.setInt(1, song.getsId());
                statement.setString(2, song.getName());
                statement.setString(3, song.getSinger());
                statement.setInt(4, song.getMusicType().getTypeId());
                MultipartFile file = song.getFile();
                InputStream fileStream = file.getInputStream();
                statement.setBlob(5, fileStream);
                statement.executeUpdate();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }
}
