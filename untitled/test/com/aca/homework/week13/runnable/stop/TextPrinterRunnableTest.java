package com.aca.homework.week13.runnable.stop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

class TextPrinterRunnableTest {

    @Test
    public void testRun() {
        ConsumerForTest consumer = new ConsumerForTest();
        TextPrinterRunnable testSubject = new TextPrinterRunnable("name", consumer);
        new Thread(testSubject).start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testSubject.stop();

        Assertions.assertEquals(1, consumer.getCallsNumber());
        Assertions.assertEquals("name", consumer.getString());
    }
}