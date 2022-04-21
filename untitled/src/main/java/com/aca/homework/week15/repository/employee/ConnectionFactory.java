package com.aca.homework.week15.repository.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DATABASE_URL = "jdbc:postgresql://127.0.0.1:7432/aca";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = null;

    public Connection getObject() {
        try {
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Connection error with database having url " + DATABASE_URL + ", UserName " + USERNAME + "end password " + PASSWORD, e);
        }
    }

    public static String getDatabaseURL() {
        return DATABASE_URL;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getUsername() {
        return USERNAME;
    }
}