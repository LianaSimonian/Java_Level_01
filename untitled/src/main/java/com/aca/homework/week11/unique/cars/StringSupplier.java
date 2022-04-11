package com.aca.homework.week11.unique.cars;

import java.util.Scanner;

public class StringSupplier implements Supplier<String> {
    @Override
    public String get() {
        return new Scanner(System.in).nextLine();
    }
}
