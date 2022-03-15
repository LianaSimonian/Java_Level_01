package com.aca.homework.week9.observable.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayObservableListTest {
    @Test
    public void testAddWhenThereIsNoAddedListeners() {
        ObservableList<String> testSubject = new ArrayObservableList<>();
        testSubject.add("hello");
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals("hello", testSubject.get(0));
    }

    @Test
    public void testAddWhenThereIsOneAddedListener() {
        ObservableList<Object> testSubject = new ArrayObservableList<>();
        int[] counter = {1, 2};
        testSubject.addListener(new ListChangeListener<Object>() {
            @Override
            public void onAdded(Object item) {
                counter[0] = 0;
            }
        });

        testSubject.add(Integer.valueOf((98)));
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals(98, testSubject.get(0));
        Assertions.assertEquals(0, counter[0]);
    }

    @Test
    public void testAddWhenThereAreTwoAddedListener() {
        int[] counter = {1, 2};
        ObservableList<Object> testSubject = new ArrayObservableList<>();

        testSubject.addListener(new ListChangeListener<Object>() {
            @Override
            public void onAdded(Object item) {
                counter[0] = 0;
            }
        });
        testSubject.addListener(new ListChangeListener<Object>() {
            @Override
            public void onAdded(Object item) {
                counter[1] = 1;
            }
        });

        testSubject.add(Integer.valueOf((98)));
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals(98, testSubject.get(0));
        Assertions.assertEquals(0, counter[0]);
        Assertions.assertEquals(1, counter[1]);
    }
}