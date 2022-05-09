package com.aca.homework.week15.service.user;

import java.sql.Connection;
import java.sql.SQLException;

public class UserRepository {

    private final ConnectionFactory connectionFactory;
    private final SQLGenerator sqlGenerator;

    public UserRepository(ConnectionFactory connectionFactory, SQLGenerator sqlGenerator) {
        this.connectionFactory = connectionFactory;
        this.sqlGenerator = sqlGenerator;
    }

    void save(User user) {
        if (user == null) throw new IllegalArgumentException("user argument can not be null");

        Connection connection = connectionFactory.getObject();
        String sqlInsert = sqlGenerator.generateInsert(user);
        try {
            connection.createStatement().execute(sqlInsert);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing sql:\n" + sqlInsert, e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error at closing connection with database ", e);
        }
    }
}