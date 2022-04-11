package com.aca.classroom.week6.set;


import com.aca.classroom.week6.set.ArraySet;
import com.aca.classroom.week6.set.Set;
import com.aca.classroom.week6.set.User;
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
    public void testSizeWhen5SameUsersWereAdded(){
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));
        testSubject.add(new User("f", "l"));

        Assertions.assertEquals(5, testSubject.size());
    }

    @Test
    public void testForIntegersArray() {
        Integer[] ints = {1, 5, 6};
        method1(ints);
        Assertions.assertNotEquals(null, ints);
    }

    public static void method1(Integer[] array) {
        array = null;
    }
}

