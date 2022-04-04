package com.aca.homework.week13.consumer;

import java.util.List;
import java.util.function.Consumer;

public class TextPrinter {

    private Consumer<String> consumer;

    public TextPrinter(@ConsumerPrinter Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void printAll(List<String> list) {
        if (list == null) throw new IllegalArgumentException("list can not be null");
        list.forEach(consumer);
    }
}