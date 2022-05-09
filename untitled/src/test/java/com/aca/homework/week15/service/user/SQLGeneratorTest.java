package com.aca.homework.week15.service.user;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SQLGeneratorTest {
    @Test
    public void testGenerateInsert() {
        SQLGenerator testSubject = new SQLGenerator();
        Assertions.assertEquals("insert into USERS (username, name) values ('john', 'kehoe');",
                testSubject.generateInsert(new User("john", "kehoe")));
    }
}