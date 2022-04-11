package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberAdderRunnableTest {

    @Test
    public void testRun() {
        List<Integer> list = new SafeList<>();
        Runnable testSubject = new NumberAdderRunnable(list, 12);
        testSubject.run();
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(12, list.get(0));
    }
}