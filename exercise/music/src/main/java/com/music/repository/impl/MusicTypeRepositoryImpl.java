package com.music.repository.impl;

import com.music.database.DBConnection;
import com.music.database.MyQuery;
import com.music.model.MusicType;
import com.music.repository.itf.IMusicTypeRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicTypeRepositoryImpl implements IMusicTypeRepository {
    @Override
    public List<MusicType> showList() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<MusicType> musicTypes = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SELECT_ALL_TYPE);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int typeId = resultSet.getInt("typeId");
                    String type = resultSet.getString("type");
                    MusicType musicType = new MusicType(typeId, type);
                    musicTypes.add(musicType);
                }
            } catch (SQLException e) {
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
        return musicTypes;
    }

    @Override
    public MusicType search(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        MusicType musicType = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(MyQuery.SEARCH_TYPE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int typeId = resultSet.getInt("typeId");
                    String type = resultSet.getString("type");
                    musicType = new MusicType(typeId, type);
                    break;
                }
            } catch (SQLException e) {
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
        return musicType;
    }
}
