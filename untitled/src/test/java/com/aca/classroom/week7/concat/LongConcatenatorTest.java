package com.aca.classroom.week7.concat;

import com.aca.classroom.week7.concat.LongConcatenator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongConcatenatorTest {

    private LongConcatenator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new LongConcatenator();

    }

    @Test
    public void test2Numbers() {
        Assertions.assertEquals("1050", testSubject.concat(10, 50));
    }

    @Test
    public void test2Numbers2() {
        Assertions.assertEquals("24", testSubject.concat(2, 4));
    }
}
