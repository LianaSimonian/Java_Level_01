package com.aca.homework.week21.optional;

import java.util.function.Consumer;

public class PrinterConsumer implements Consumer<Character> {

    @Override
    public void accept(Character s) {
        System.out.println(s);
    }
}
