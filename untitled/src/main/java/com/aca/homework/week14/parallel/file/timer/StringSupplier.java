package com.aca.homework.week14.parallel.file.timer;

import java.util.Scanner;
import java.util.function.Supplier;

public class StringSupplier implements Supplier<String> {

    @Override
    public String get() {
        return new Scanner(System.in).nextLine();
    }
}
