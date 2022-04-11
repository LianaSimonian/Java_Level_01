package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserUpdateParamsTest {
    @Test
    public void testConstructorWhenUserNameIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UserUpdateParams(null, "fistName", 12);
            }
        });
        Assertions.assertEquals("username can not be  null", illegalArgumentException.getMessage());

    }

    @Test
    public void testConstructorWhenFirstNameIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UserUpdateParams("username", null, 12);
            }
        });
        Assertions.assertEquals("firstname can not be null", illegalArgumentException.getMessage());

    }

    @Test
    public void testConstructorWhenAgeIsNegative() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new UserUpdateParams("username", "firstname", -5);
            }
        });
        Assertions.assertEquals("age can not be  negative", illegalArgumentException.getMessage());
    }

    @Test
    public void testConstructorWhenNoFieldsAreNullable() {
        UserUpdateParams testSubject = new UserUpdateParams("username", "firstname", 12);
        Assertions.assertNotNull(testSubject);
        Assertions.assertEquals("username", testSubject.getUserName());
        Assertions.assertEquals("firstname", testSubject.getFirstName());
        Assertions.assertEquals(12, testSubject.getAge());
    }

    @Test
    public void testGetUserName() {
        UserUpdateParams testSubject = new UserUpdateParams("username", "firstname", 12);
        Assertions.assertEquals("username", testSubject.getUserName());
    }

    @Test
    public void testGetFirstName() {
        UserUpdateParams testSubject = new UserUpdateParams("username", "firstname", 12);
        Assertions.assertEquals("firstname", testSubject.getFirstName());
    }

    @Test
    public void testGetAge() {
        UserUpdateParams testSubject = new UserUpdateParams("username", "firstname", 12);
        Assertions.assertEquals(12, testSubject.getAge());
    }
}