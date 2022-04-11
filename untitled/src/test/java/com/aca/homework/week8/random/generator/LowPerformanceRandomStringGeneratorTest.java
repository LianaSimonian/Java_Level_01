package com.aca.homework.week8.random.generator;

import com.aca.homework.week8.random.generator.LowPerformanceRandomStringGenerator;
import com.aca.homework.week8.random.generator.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowPerformanceRandomStringGeneratorTest {
    private LowPerformanceRandomStringGenerator testObject;

    @BeforeEach
    public void setUp() {
        testObject = new LowPerformanceRandomStringGenerator();
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