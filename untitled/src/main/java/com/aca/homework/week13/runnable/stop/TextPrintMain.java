package com.aca.homework.week13.runnable.stop;

import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class TextPrintMain {

    public static void main(String[] args) {
        TextPrinterRunnable runnable = new TextPrinterRunnable("HELLO WORLD!", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        new Thread(runnable).start();

        try {
            sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnable.stop();
    }
}