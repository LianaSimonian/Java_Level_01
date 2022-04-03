package com.aca.classroom.week12.supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class BooleanSupplier {
    public static void main(String[] args) {
        System.out.println(new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return new Scanner(System.in).nextBoolean();
            }
        }.get());
    }
}