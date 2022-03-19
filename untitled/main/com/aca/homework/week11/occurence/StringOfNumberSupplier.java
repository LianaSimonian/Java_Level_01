package com.aca.homework.week11.occurence;

import java.util.Scanner;

public class StringOfNumberSupplier implements Supplier<String> {
    @Override
    public String get() {
        return new Scanner(System.in).nextLine();
    }
}
