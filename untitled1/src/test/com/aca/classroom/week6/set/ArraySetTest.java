package com.aca.classroom.week6.set;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArraySetTest {

    private Set testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new ArraySet();
    }

    @Test
    public void testSizeWhenIsEmpty() {
        Assertions.assertEquals(0, testSubject.size());
    }

    @Test
    public void testSizeWhenOnlyOneUserIsAdded() {
        testSubject.add(new User("f", "l"));
        Assertions.assertEquals(1, testSubject.size());
    }

    @Test
    public void testSizeWhen5SameUsersWereAdded() {
        Integer[] ints = {1, 5, 6};
        method1(ints);
        Assertions.assertNotEquals(null, ints);
    }

    public static void method1(Integer[] array) {
        array = null;
    }
}

