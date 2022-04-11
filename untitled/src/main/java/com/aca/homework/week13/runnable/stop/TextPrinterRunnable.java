package com.aca.homework.week13.runnable.stop;

import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class TextPrinterRunnable implements Runnable {

    private final String name;
    private boolean isRunning = true;
    @PrinterConsumer
    private final Consumer<String> consumer;

    public TextPrinterRunnable(String name, Consumer<String> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (isRunning) {
            consumer.accept(name);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }
}