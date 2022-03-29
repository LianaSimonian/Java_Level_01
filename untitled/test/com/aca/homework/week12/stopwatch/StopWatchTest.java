package com.aca.homework.week12.stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StopWatchTest {

    @Test
    public void testStart() {
        StopWatch testSubject = new StopWatch(DisplayType.SECONDS_AND_MILLIS);

        new Thread(new Runnable() {
            @Override
            public void run() {
                testSubject.start();
            }
        }).start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
        long timer = testSubject.getTimer();
        Assertions.assertTrue(timer >= 10);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {

        }
        long timer1 = testSubject.getTimer();
        Assertions.assertTrue(timer1 > timer && timer1 >= 20);
    }

    @Test
    public void testGetTimer() {
        StopWatchForTest testSubject = new StopWatchForTest(DisplayType.SECONDS_AND_MILLIS);
        testSubject.setTimer(12);
        Assertions.assertEquals(12, testSubject.getTimer());
    }
}