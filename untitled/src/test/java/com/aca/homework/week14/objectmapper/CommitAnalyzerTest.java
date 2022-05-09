package com.aca.homework.week14.objectmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommitAnalyzerTest {

    @Test
    public void testCount() {
        Assertions.assertEquals(301, new CommitAnalyzer(".\\src\\main\\java\\com\\aca\\homework\\week14\\objectmapper\\commits-data.json").count());
    }
}
