package com.aca.classroom.week12.functional;

import static java.lang.Thread.sleep;

public class AtomicRunnable {
    public static synchronized void increment(int[] a) {
        a[0]++;// =0 + 1,=0 + 1
    }

    public static void main(String[] args) throws InterruptedException {
        final int[] a = {0};

        Thread[] threads = new Thread[4000];//List
        for (int j = 0; j < 4000; j++) {
            threads[j] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    increment(a);
                    //System.out.println(a[0]);

                }

            });
            threads[j].start();
        }
        for (int i = 0; i < 4000; i++)
            threads[i].join();

        System.out.println("a[0]= " + a[0]);
    }
}
