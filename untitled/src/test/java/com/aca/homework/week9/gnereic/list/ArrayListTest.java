package com.aca.homework.week9.gnereic.list;

import com.aca.homework.week9.gnereic.list.ArrayList;
import com.aca.homework.week9.gnereic.list.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayListTest {
    @Test
    public void testSizeForInteger() {
        List<Integer> testSubject = new ArrayList<>();
        testSubject.add(Integer.valueOf(12));
        testSubject.add(178);
        Assertions.assertEquals(2, testSubject.size());
    }

    @Test
    public void testSizeForString() {
        List<String> testSubject = new ArrayList<>();
        testSubject.add("string1");
        testSubject.add("string2");
        Assertions.assertEquals(2, testSubject.size());
    }

    @Test
    public void testGetForString() {
        List<String> testSubject = new ArrayList<>();
        testSubject.add("string1");
        testSubject.add("string2");
        Assertions.assertEquals("string1", testSubject.get(0));
        Assertions.assertEquals("string2", testSubject.get(1));
    }

    @Test
    public void testAddForString() {
        List<String> testSubject = new ArrayList<>();
        testSubject.add("string1");
        testSubject.add("string2");
        Assertions.assertEquals(2, testSubject.size());
        Assertions.assertEquals("string1", testSubject.get(0));
        Assertions.assertEquals("string2", testSubject.get(1));
    }

    @Test
    public void testGetForInteger() {
        List<Integer> testSubject = new ArrayList<>();
        testSubject.add(Integer.valueOf(1));
        testSubject.add(Integer.valueOf(2));
        Assertions.assertEquals(1, testSubject.get(0));
        Assertions.assertEquals(2, testSubject.get(1));
    }

    @Test
    public void testAddForInteger() {
        List<Integer> testSubject = new ArrayList<>();
        testSubject.add(Integer.valueOf(3));
        testSubject.add(Integer.valueOf(4));
        Assertions.assertEquals(2, testSubject.size());
        Assertions.assertEquals(3, testSubject.get(0));
        Assertions.assertEquals(4, testSubject.get(1));
    }

}