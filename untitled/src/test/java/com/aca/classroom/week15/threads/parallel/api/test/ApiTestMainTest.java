package com.aca.classroom.week15.threads.parallel.api.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiTestMainTest {

    @Test
    public void testStart() {
        ApiTestMain testSubject = new ApiTestMain();
        testSubject.start();
        Assertions.assertEquals(5000, testSubject.getSize());
    }
}