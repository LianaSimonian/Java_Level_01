package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SafeListTest {

    private List<Integer> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new SafeList<>();
    }

    @Test
    public void testAdd() {
        testSubject.add(12);
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals(12, testSubject.get(0));
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, testSubject.size());
        testSubject.add(12);
        Assertions.assertEquals(1, testSubject.size());
    }
}