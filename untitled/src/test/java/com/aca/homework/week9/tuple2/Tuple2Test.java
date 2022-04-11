package com.aca.homework.week9.tuple2;

import com.aca.homework.week9.tuple2.Tuple2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tuple2Test {
    @Test
    public void testGettersForTuple2StringInteger() {
        Tuple2<String, Integer> testSubject = new Tuple2<>("text", 45);
        Assertions.assertEquals("text", testSubject.getT1());
        Assertions.assertEquals(45, testSubject.getT2());
    }

    @Test
    public void testGettersForTuple2LongInteger() {
        Tuple2<Long, Integer> testSubject = new Tuple2<>(100L, 45);
        Assertions.assertEquals(100L, testSubject.getT1());
        Assertions.assertEquals(45, testSubject.getT2());
    }

}