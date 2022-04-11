package com.aca.homework.week14.shared.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class SharedListMainTest {

    @Test
    public void testStart() {
        SharedListMain testSubject = new SharedListMain();
        List<Integer> resultList = testSubject.getSharedList();

        Assertions.assertEquals(0, resultList.size());

        int size = SharedListMain.size();
        Assertions.assertEquals(size, testSubject.start());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }

        Assertions.assertEquals(size, resultList.size());
        Assertions.assertTrue(resultList.containsAll(list));
        Assertions.assertTrue(list.containsAll(resultList));
    }
}