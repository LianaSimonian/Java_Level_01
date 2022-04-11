package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnsafeListTest {
    private List<Integer> testSubject;
    @BeforeEach
    public void setUp() {
        testSubject = new UnsafeList<>();
    }

    @Test
    public void testAdd() {
        testSubject.add(12);
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals(12,testSubject.get(0));
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, testSubject.size());
        testSubject.add(12);
        Assertions.assertEquals(1, testSubject.size());
    }
    @Test
    public void testGet(){
        testSubject.add(12);
        testSubject.add(15);
        Assertions.assertEquals(12,testSubject.get(0));
        Assertions.assertEquals(15,testSubject.get(1));
    }
    @Test
    public void testContains(){
        testSubject.add(12);
        Assertions.assertTrue(testSubject.contains(12));
    }

}