package com.aca.homework.week13.consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;
import java.util.List;

class TextPrinterTest {

    private TextPrinter testSubject;
    private PrinterConsumerForTest consumer;

    @BeforeEach
    public void setUp() {
        consumer = new PrinterConsumerForTest();
        testSubject = new TextPrinter(consumer);
    }

    @Test
    public void testWhenListIsEmpty() {
        testSubject.printAll(Collections.emptyList());
        Assertions.assertEquals(0, consumer.getCallsNumber());
        Assertions.assertEquals(Collections.emptyList(), consumer.getArgumentsList());
    }

    @Test
    public void testWhenListContains1Item() {
        testSubject.printAll(Collections.singletonList("String"));
        Assertions.assertEquals(1, consumer.getCallsNumber());
        Assertions.assertEquals(Collections.singletonList("String"), consumer.getArgumentsList());
    }

    @Test
    public void testWhenListContains2Items() {
        testSubject.printAll(List.of("String1", "String2"));
        Assertions.assertEquals(2, consumer.getCallsNumber());
        Assertions.assertEquals(List.of("String1", "String2"), consumer.getArgumentsList());
    }

    @Test
    public void testPrintAllWhenArgumentIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.printAll(null);
            }
        });
        Assertions.assertEquals("list can not be null", illegalArgumentException.getMessage());
    }
}