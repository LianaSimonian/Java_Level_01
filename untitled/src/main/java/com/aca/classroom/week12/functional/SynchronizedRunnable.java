package com.aca.classroom.week12.functional;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

public class SynchronizedRunnable {
    public static void main(String[] args) throws InterruptedException {
        final int[] a = {0};

        Thread[] threads = new Thread[4000];
        for (int j = 0; j < 4000; j++) {
            threads[j] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (System.out) {
                        // a[0]++;
                        System.out.println(a[0]++);
                    }
                }
            });
            threads[j].start();
        }
        for (int i = 0; i < 4000; i++)
            threads[i].join();

        out.println("a[0]=" + a[0]);
    }
}