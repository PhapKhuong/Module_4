package com.music.repository.impl;

import com.music.database.DBConnection;
import com.music.database.MyQuery;
import com.music.model.MusicType;
import com.music.model.Song;
import com.music.repository.itf.ISongRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {

    @Override
    public List<Song> showList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Song> songs = new ArrayList<>();

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
                    InputStream inputStream = blob.getBinaryStream();
                    Files.copy(inputStream, Paths.get("Download"+name));

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
        return songs;
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
