package com.aca.homework.week13.consumer;

import java.util.function.Consumer;

public class PrinterConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
