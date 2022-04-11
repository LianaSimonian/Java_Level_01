package com.aca.homework.week13.runnable.stop.classroom.version;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextPrinterRunnableTest {
    @Test
    public void testRun() {
        TextPrinterRunnable testSubject = new TextPrinterRunnable(new Printer() {
            @Override
            public void print(String text) {
                Assertions.assertEquals(text, "Hello world");
            }
        }, "Hello world");
        new Thread(new Runnable() {
            @Override
            public void run() {
                testSubject.stop();
            }
        }).start();
        testSubject.run();
    }
}