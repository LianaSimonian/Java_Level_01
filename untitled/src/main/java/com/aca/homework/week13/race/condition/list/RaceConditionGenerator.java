package com.aca.homework.week13.race.condition.list;

import java.util.function.Supplier;

public class RaceConditionGenerator {

    private static int THREADS_SIZE = 10_000;
    private final Thread[] threads = new Thread[THREADS_SIZE];
    private final List<Integer> integerList;

    public RaceConditionGenerator(Supplier<Boolean> supplier) {
        boolean listType = supplier.get();
        if (listType) {
            integerList = new SafeList<>();
        } else {
            integerList = new UnsafeList<>();
        }
        for (int i = 0; i < THREADS_SIZE; i++) {
            threads[i] = new Thread(new NumberAdderRunnable(integerList, i));
        }
    }

    public int start() {
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return integerList.size();
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public static int getThreadsSize() {
        return THREADS_SIZE;
    }
}