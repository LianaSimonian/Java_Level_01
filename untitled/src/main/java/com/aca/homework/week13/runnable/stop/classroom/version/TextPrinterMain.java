package com.aca.homework.week13.runnable.stop.classroom.version;

public class TextPrinterMain {
    public static void main(String[] args) throws InterruptedException {
        TextPrinterRunnable runnable = new TextPrinterRunnable(
                new SystemPrinter(),
                "Hello world!"
        );
        final Thread thread0 = new Thread(runnable);
        thread0.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runnable.stop();
            }
        });
        thread1.start();
    }
}
