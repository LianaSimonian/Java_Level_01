package com.aca.classroom.week15.threads.parallel.file.timer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class TimerMainTest {

    @Test
    public void test5And3() {
        TimerMain testSubject = new TimerMain(new Supplier<String>() {
            private String[] strings = {"timer1", "timer2", "timer1", "timer2"};
            private int counter;

            @Override
            public String get() {
                if (counter == 0) {
                    return strings[counter++];
                }
                if (counter == 1) {
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return strings[counter++];
                }
                if (counter == 2) {
                    try {
                        Thread.sleep(3200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return strings[counter++];
                }
                if (counter == 3)
                    return strings[counter];
                return "";
            }
        });
        testSubject.startTimer();
        Assertions.assertEquals(5, TimerMain.getSecondsFromFile("timer1"));
        Assertions.assertEquals(3, TimerMain.getSecondsFromFile("timer2"));
    }

    @Test
    public void test5End5() {
        TimerMain testSubject = new TimerMain(new Supplier<String>() {
            private String[] strings = {"timer1", "timer2", "timer1", "timer2"};
            private int counter;

            @Override
            public String get() {
                if (counter == 0) {
                    return strings[counter++];
                }
                if (counter == 1) {
                    return strings[counter++];
                }
                if (counter == 2) {
                    try {
                        Thread.sleep(5200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return strings[counter++];
                }
                if (counter == 3)
                    return strings[counter];
                return "";
            }
        });
        testSubject.startTimer();
        Assertions.assertEquals(5, TimerMain.getSecondsFromFile("timer1"));
        Assertions.assertEquals(5, TimerMain.getSecondsFromFile("timer2"));
    }
}