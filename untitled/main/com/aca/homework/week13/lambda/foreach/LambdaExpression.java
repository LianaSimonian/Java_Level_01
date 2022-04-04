package com.aca.homework.week13.lambda.foreach;

import java.util.List;
import java.util.function.Consumer;

public class LambdaExpression {
    public static void main(String[] args) {
        List<String> list = List.of("1", "10", "text", "25");

        list.forEach((s) -> {
            System.out.println("item value is " + s);
            System.out.println("item length " + s.length());
        });

        System.out.println();

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("item value is " + s);
                System.out.println("item length " + s.length());
            }
        });
    }
}
