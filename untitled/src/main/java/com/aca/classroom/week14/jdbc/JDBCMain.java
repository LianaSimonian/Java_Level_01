package com.aca.classroom.week14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMain {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7432/aca", "postgres", null);
        connection.createStatement().execute("insert into users (full_name,age) values ('test2',20)");
        ResultSet resultSet = connection.createStatement().executeQuery("select * from users");
    }
}
//djbc
//datasorce other connection
//lib hichari
//hicari
//map key imutable
//map,list implementation
//how can i exec sqlstatment using 1 lib,using more libes
//executor executor service
//