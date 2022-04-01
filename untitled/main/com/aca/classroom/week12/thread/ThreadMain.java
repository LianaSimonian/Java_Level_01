package com.aca.classroom.week12.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(16);
        //Disadvantage:join() not manageable,we do not know when all the threads will end
        //Advantage:16 threads are running at any time
        System.out.println(System.currentTimeMillis());

        for (int i = 0; i < 16000; i++) {
            //new Thread(new MyRunnable()).start();
            executor.execute(new MyRunnable(i));//16000 runnable works  from 16 threads
        }
        for (int i = 0; i < 16000; i++) {
            new Thread(new MyRunnable(i)).start();//16000 runnable works  from 16000 thread
            // executor.execute(new MyRunnable(i));
        }

        //Advantage of Executor
        Thread[] threads = new Thread[16];
        int c = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 16; j++) {
                threads[j] = new Thread(new MyRunnable(c++));
                threads[j].start();
            }
            for (int k = 0; k < 16; k++) {
                threads[k].join();//executor used last 16th Thread execution time,this is advantage of it
            }
        }
    }

    private static class MyRunnable implements Runnable {
        private final int number;

        public MyRunnable(int number) {
            this.number = number;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
            System.out.println(System.currentTimeMillis());
            System.out.println(number);
        }
    }
}

//hot key //shift F6//change name