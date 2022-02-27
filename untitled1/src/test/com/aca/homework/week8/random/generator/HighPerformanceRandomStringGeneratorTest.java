package com.aca.homework.week8.random.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HighPerformanceRandomStringGeneratorTest {
    private HighPerformanceRandomStringGenerator testObject;

    @BeforeEach
    public void setUp() {
        testObject = new HighPerformanceRandomStringGenerator();
    }

    @Test
    public void testWrongNumber() {
        Result randomString = testObject.randomString(100);
        Assertions.assertTrue(randomString.getResultText().equalsIgnoreCase("Error") && randomString.getExecutionDurationByMillis() == 0);
    }

    @Test
    public void test30000() {
        Result randomString = testObject.randomString(30000);
        Assertions.assertTrue(randomString.getResultText().length() == 30000 && randomString.getExecutionDurationByMillis() > 0);

    }

}