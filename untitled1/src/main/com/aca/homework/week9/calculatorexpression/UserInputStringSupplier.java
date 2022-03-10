package com.aca.homework.week9.calculatorexpression;

import java.util.Scanner;

public class UserInputStringSupplier implements StringSupplier {
    @Override
    public String get() {
        return new Scanner(System.in).nextLine();
    }
}
