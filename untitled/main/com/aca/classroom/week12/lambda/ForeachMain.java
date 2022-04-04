package com.aca.classroom.week12.lambda;

import java.util.List;
import java.util.function.Consumer;

public class ForeachMain {
    public static void main(String[] args) {
        List<String> list = List.of("String1", "String2");
        list.forEach(s -> System.out.println(s));

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        list.forEach(consumer1);

        Consumer<String> consumer = s -> {   //lambda exception
            System.out.println(s);
        };
        list.forEach(consumer);

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
//foreach....callback