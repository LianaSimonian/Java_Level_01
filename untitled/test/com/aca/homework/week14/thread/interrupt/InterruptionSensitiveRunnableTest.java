package com.aca.homework.week14.thread.interrupt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class InterruptionSensitiveRunnableTest {

    private Runnable testSubject;
    private List<String> sharedList;

    @BeforeEach
    public void setUp() {
        sharedList = new LinkedList<>();
        testSubject = new InterruptionSensitiveRunnable(sharedList);
    }

    @Test
    public void testImmediateInterrupt() {
        Thread thread = new Thread(testSubject);
        thread.start();
        Thread thread1 = new Thread(() -> {
            thread.interrupt();
        });
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(0, sharedList.size());
    }

    @Test
    public void testInterruptIn1Sec() {
        Thread thread = new Thread(testSubject);
        thread.start();

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        });
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(0, sharedList.size());
    }

    @Test
    public void testInterruptIn3Sec() {
        Thread thread = new Thread(testSubject);
        thread.start();

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        });
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(1, sharedList.size());
    }

    @Test
    public void testInterruptIn5Sec() {
        Thread thread = new Thread(testSubject);
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.interrupt();
            }
        });
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(2, sharedList.size());
    }
}