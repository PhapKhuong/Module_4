package com;

import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

@Repository
public class SongRepository {
    static final String FILE_PATH = "C:\\Dropbox\\Codegym\\module2\\module2_excercise\\src\\ss17_binary_file\\BinaryStream.jpg";

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        add();
    }


    public static void add() throws SQLException, FileNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            statement = connection.prepareStatement(MyQuery.INSERT_NEW_SONG);
            statement.setInt(1, 1);
            statement.setString(2, "fgd");
            statement.setString(3, "dfhf");
            statement.setInt(4, 2);
            FileInputStream fis = new FileInputStream(FILE_PATH);
            statement.setBinaryStream(5, fis);
            statement.executeQuery();
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
