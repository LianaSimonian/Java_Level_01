package com.aca.homework.week11.occurence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class KeyCalculatorTest {
    private KeyCalculator testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new KeyCalculator(new StringOfNumberSupplierTest());
    }

    @Test
    public void testAskAndCalculate() {
        Map<String, Integer> map = testSubject.askAndCalculate();
        Assertions.assertEquals(3, map.get("1"));
        Assertions.assertEquals(2, map.get("5"));
        Assertions.assertEquals(1, map.get("49"));
    }
}