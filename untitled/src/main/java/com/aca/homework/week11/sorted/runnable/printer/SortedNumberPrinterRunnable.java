package com.aca.homework.week11.sorted.runnable.printer;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedNumberPrinterRunnable implements Runnable, Comparable<SortedNumberPrinterRunnable> {
    private static final int MIN = 10;
    private static final int MAX = 200;
    private final int number;
    private final long waitTimeMillis;

    public SortedNumberPrinterRunnable(int number) {
        this.number = number;
        waitTimeMillis = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
    }

    @Override
    public int compareTo(SortedNumberPrinterRunnable o) {
        return Long.valueOf(waitTimeMillis).compareTo(o.waitTimeMillis);
    }

    @Override
    public void run() {
        System.out.println(waitTimeMillis);
        waitSomeMillis();
        System.out.println("number= " + number);
    }

    private void waitSomeMillis() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < waitTimeMillis) ;
    }

    public static SortedSet<Runnable> createRunnables() {
        SortedSet<Runnable> runnables = new TreeSet<>();
        for (int i = 1; i <= 100; i++) {
            runnables.add(new SortedNumberPrinterRunnable(i));
        }
        return runnables;
    }

    public long getWaitTimeMillis() {
        return waitTimeMillis;
    }

    @Override
    public String toString() {
        return "number=" + number + ", waitTimeMillis=" + waitTimeMillis;
    }

    public static void runAll(SortedSet<Runnable> set) {
        for (Runnable runnable : set) {
            runnable.run();
        }
    }

    public static void main(String[] args) {
        Iterator<Runnable> iterator = createRunnables().iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println();
        Iterator<Runnable> descendingIterator = ((TreeSet<Runnable>) createRunnables()).descendingIterator();
        while (descendingIterator.hasNext())
            System.out.println(descendingIterator.next());
    }
}