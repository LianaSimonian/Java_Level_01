package com.aca.homework.week11.runnable.printer;

import java.util.LinkedList;
import java.util.List;

public class NumberPrinterRunnable implements Runnable {
    private final int number;

    public NumberPrinterRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        wait100Millis();
        System.out.println("number= " + number);
    }

    private void wait100Millis() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 100) ;
    }

    public static List<Runnable> createRunnables() {
        List<Runnable> runnableList = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            runnableList.add(new NumberPrinterRunnable(i));
        }
        return runnableList;
    }

    public static void runAll(List<Runnable> list) {
        for (Runnable runnable : list) {
            runnable.run();
        }
    }
}