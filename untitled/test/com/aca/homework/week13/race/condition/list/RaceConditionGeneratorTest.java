package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class RaceConditionGeneratorTest {

    @Test
    public void testStart() {
        RaceConditionGenerator testSubject = new RaceConditionGenerator(new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return true;
            }
        });

        int listSize = RaceConditionGenerator.getThreadsSize();
        Assertions.assertEquals(listSize, testSubject.start());

        List<Integer> resultList = testSubject.getIntegerList();
        for (int i = 0; i < listSize; i++) {
            Assertions.assertTrue(resultList.contains(i));
        }
    }
}