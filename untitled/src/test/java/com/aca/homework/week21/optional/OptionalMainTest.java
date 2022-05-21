package com.aca.homework.week21.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

class OptionalMainTest {

    private OptionalMain testSubject;
    private PrinterConsumerForTest consumer;

    @BeforeEach
    public void setUp() {
        consumer = new PrinterConsumerForTest();
        testSubject = new OptionalMain(consumer);
    }

    @Test
    public void testWhenOptionalIsEmpty() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.printFirstSymbol(Optional.empty());
            }
        });
        Assertions.assertEquals("the string param of printFirstSymbol() cannot be null", illegalArgumentException.getMessage());
    }

    @Test
    public void testWhenStringIsEmpty() {
        testSubject.printFirstSymbol(Optional.of(""));
        Assertions.assertEquals(0, consumer.getCallsNumber());
    }

    @Test
    public void testWhenStringHas1Symbol() {
        testSubject.printFirstSymbol(Optional.of("a"));
        Assertions.assertEquals(0, consumer.getCallsNumber());
    }

    @Test
    public void testWhenStringHas2Symbols() {
        testSubject.printFirstSymbol(Optional.of("abc"));
        Assertions.assertEquals(1, consumer.getCallsNumber());
        Assertions.assertEquals('b', consumer.getSymbol());
    }
}