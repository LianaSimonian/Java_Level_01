package com.aca.homework.week12.thread;

public class ThreadTermination {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started");

        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Finished");
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis());
        }
    }
}
