package com.aca.homework.week12.car.wash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarWashTest {

    private CarWash testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CarWash(new CarWashService("JILLY", 5, 15.5), new CarRepositoryForTest());
    }

    @Test
    public void testWash1Time() {
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
    }

    @Test
    public void testWash5Times() {
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(0, testSubject.wash("11AAA21"));
    }

    @Test
    public void testWash6Times() {
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(0, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));

    }

    @Test
    public void testWash10Times() {
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(0, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(15.5, testSubject.wash("11AAA21"));
        Assertions.assertEquals(0, testSubject.wash("11AAA21"));
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("JILLY", testSubject.getName());
    }
}