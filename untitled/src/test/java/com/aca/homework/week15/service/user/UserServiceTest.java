package com.aca.homework.week15.service.user;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    @Test
    public void testCreate() {
        UserService testSubject = new UserService(new UserRepository(new ConnectionFactory(), new SQLGenerator()));
        Assertions.assertEquals(new User("username", "name"), testSubject.create(new UserCreateParams("username", "name")));
    }
}