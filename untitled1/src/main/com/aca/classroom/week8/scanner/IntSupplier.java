package com.aca.classroom.week8.scanner;

import java.util.Scanner;

//intsuplier interface
public class IntSupplier {
    public int get() {
        return new Scanner(System.in).nextInt();
    }
}
