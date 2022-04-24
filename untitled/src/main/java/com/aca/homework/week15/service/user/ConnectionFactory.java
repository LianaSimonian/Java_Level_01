package com.aca.homework.week15.service.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getObject() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7432/aca", "postgres", null);
        } catch (SQLException e) {
            throw new RuntimeException("Connection error with database having url dbc:postgresql://127.0.0.1:7432/aca", e);
        }
    }
}