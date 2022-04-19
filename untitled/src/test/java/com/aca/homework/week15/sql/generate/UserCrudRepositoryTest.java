package com.aca.homework.week15.sql.generate;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class UserCrudRepositoryTest {

    @Test
    public void testSave() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7432/aca", "postgres", null);

        } catch (SQLException e) {
            throw new RuntimeException("Connection error with \"jdbc:postgresql://127.0.0.1:7432/aca\"", e);
        }

        UserCrudRepository testSubject = new UserCrudRepository(connection);
        testSubject.save(new User("Name1", 112));
    }
}