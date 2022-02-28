package com.aca.classroom.week8.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserTest {
    @Test
    public void testWhenUsernameIsNull() {
        RuntimeException exeption = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new User(null, "firstname");
            }
        });
        Assertions.assertEquals(exeption.getMessage(), "the lastName is null");
    }

    @Test
    public void testWhenFirstnameIsNull() {
        RuntimeException exeption = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new User("lastname", null);
            }
        });
        Assertions.assertEquals(exeption.getMessage(), "the firstName is null");
    }
}