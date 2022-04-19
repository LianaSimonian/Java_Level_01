package com.aca.homework.week15.sql.generate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SQLGeneratorTest {

    @Test
    public void testGenerateInsert() {
        SQLGenerator testSubject = new SQLGenerator();
        String result = "insert into users (full_name, age) values ('john kehoe', 45);";
        Assertions.assertEquals(result, testSubject.generateInsert(new User("john kehoe", 45)));
    }
}