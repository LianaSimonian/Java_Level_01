package com.aca.homework.week9.taskof.generic.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class QueueTest {
    private Queue<String> testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Queue<>();
    }

    @Test
    public void testWhenProduceIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.produce(null);
            }
        });
        Assertions.assertEquals("passed argument is null", illegalArgumentException.getMessage());
    }

    @Test
    public void testConsumeWhenContains1Item() {

        testSubject.produce("test");
        Assertions.assertEquals("test", testSubject.consume());
    }

    @Test
    public void testConsumeWhenQueueIsEmpty() {
        Assertions.assertTrue(testSubject.isEmpty());
    }

    @Test
    public void testConsume2TimesWhenQueueContains2Items() {
        testSubject.produce("element1");
        testSubject.produce("element2");
        Assertions.assertEquals("element1", testSubject.consume());
        Assertions.assertEquals("element2", testSubject.consume());
    }
}