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

        List<Integer> resultList = testSubject.getIntegerList();
        Assertions.assertEquals(0,resultList.size());
        int size = testSubject.start();
        Assertions.assertEquals( RaceConditionGenerator.getThreadsSize(), size);

        for (int i = 0; i < size; i++) {
            Assertions.assertTrue(resultList.contains(i));
        }
    }
}