package com.aca.homework.week10.entry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryImplTest {
    private EntryImpl<String, Integer> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new EntryImpl<>("key1", 12);
    }

    @Test
    public void testKey() {
        Assertions.assertEquals("key1", testSubject.key());
    }

    @Test
    public void testValue() {
        Assertions.assertEquals(12, testSubject.value());
    }
}