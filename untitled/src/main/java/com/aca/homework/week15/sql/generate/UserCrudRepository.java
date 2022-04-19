package com.aca.homework.week15.sql.generate;

import java.sql.Connection;
import java.sql.SQLException;

public class UserCrudRepository {

    private final Connection connection;

    public UserCrudRepository(Connection connection) {
        this.connection = connection;
    }

    public User save(User user) {
        String sqlInsert = new SQLGenerator().generateInsert(user);
        try {
            connection.createStatement().execute(sqlInsert);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing sql:\n" + sqlInsert, e);
        }
        return user;
    }
}