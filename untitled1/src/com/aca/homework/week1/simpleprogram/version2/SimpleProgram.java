package com.aca.homework.week1.simpleprogram.version2;

import java.util.Scanner;

public class SimpleProgram {
    public static void main(String[] args) {
        int c = 0;
        for (int i = 0; i < 6; i++) {
            System.out.println("input integer num:");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num == 10) {
                c++;
            }
        }
        if (c != 0)
            System.out.println("yes:the number of such terms is equal " + c);
        else System.out.println("No");
    }
}