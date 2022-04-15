package com.aca.homework.week14.shared.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SharedListMain {

    private static final int SIZE = 1000;
    private final List<Integer> sharedList = Collections.synchronizedList(new LinkedList<>());

    public int start() {
        Thread[] threads = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            threads[i] = new Thread(new NumberAdderRunnable(i + 1, sharedList));
            threads[i].start();
        }

        for (int i = 0; i < SIZE; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sharedList.size();
    }

    public List<Integer> getSharedList() {
        return sharedList;
    }

    public static int size() {
        return SIZE;
    }
}