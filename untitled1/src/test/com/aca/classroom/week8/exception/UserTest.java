package com.aca.classroom.week8.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserTest {
    @Test
    public void testWhenUsernameIsNull() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new User(null, "firstname");
            }
        });
        Assertions.assertEquals(exception.getMessage(), "the lastName is null");//why to check
    }

    @Test
    public void testWhenFirstnameIsNull() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new User("lastname", null);
            }
        });
        Assertions.assertEquals(exception.getMessage(), "the firstName is null");
    }
}