package com.dictionary.repository;

import com.dictionary.databasae.DBConnection;
import com.dictionary.databasae.DictionaryQuery;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DicRepositoryImpl implements IDicRepository {
    @Override
    public String searchByE(String e) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String str = null;

        if (connection != null) {
            try {
                st = connection.prepareStatement(DictionaryQuery.SEARCH_BY_E);
                st.setString(1, e);
                rs = st.executeQuery();
                while (rs.next()) {
                    str = rs.getString("v");

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    st.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return str;
    }

    @Override
    public String searchByV(String v) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        String str = null;

        if (connection != null) {
            try {
                st = connection.prepareStatement(DictionaryQuery.SEARCH_BY_V);
                st.setString(1, v);
                rs = st.executeQuery();
                while (rs.next()) {
                    str = rs.getString("e");

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    st.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return str;
    }
}
