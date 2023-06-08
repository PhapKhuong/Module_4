package com.forex.repository;

import com.forex.database.CurrencyQuery;
import com.forex.database.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.forex.model.Money;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MoneyRepositoryImpl implements IMoneyRepository {
    @Override
    public List<Money> display() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Money> moneyList = new ArrayList<>();

        if (connection != null) {
            try {
                st = connection.prepareStatement(CurrencyQuery.SELECT_MONEY);
                rs = st.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int value = rs.getInt("value");

                    Money money = new Money(id, name, value);
                    moneyList.add(money);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    st.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return moneyList;
    }

    @Override
    public Money search(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        Money money = null;

        if (connection != null) {
            try {
                st = connection.prepareStatement(CurrencyQuery.SEARCH_MONEY);
                st.setInt(1, id);
                rs = st.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int value = rs.getInt("value");
                    money = new Money(id, name, value);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    st.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return money;
    }
}
