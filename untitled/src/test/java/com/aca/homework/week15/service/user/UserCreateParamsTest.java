package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserCreateParamsTest {

    @Test
    public void testWhenUserNameIsNull() {
        NullFieldException nullFieldException = Assertions.assertThrows(NullFieldException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UserCreateParams(null, "name");
            }
        });
        Assertions.assertEquals("username field can not be null", nullFieldException.getMessage());
    }

    @Test
    public void testWhenNameIsNull() {
        NullFieldException nullFieldException = Assertions.assertThrows(NullFieldException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UserCreateParams("username", null);
            }
        });
        Assertions.assertEquals("name field can not be null", nullFieldException.getMessage());
    }

    @Test
    public void testWhenFieldsNotNull() {
        Assertions.assertDoesNotThrow(new Executable() {

            private UserCreateParams testSubject;

            @Override
            public void execute() throws Throwable {
                testSubject = new UserCreateParams("username", "name");
                Assertions.assertEquals("username", testSubject.getUsername());
                Assertions.assertEquals("name", testSubject.getName());
            }
        });

    }

    @Test
    public void testGetNameAndGetUserName() {
        UserCreateParams testSubject = new UserCreateParams("username", "name");
        Assertions.assertEquals("name", testSubject.getName());
        Assertions.assertEquals("username", testSubject.getUsername());
    }
}