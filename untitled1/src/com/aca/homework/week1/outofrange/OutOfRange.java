package com.aca.homework.week1.outofrange;

import java.util.Scanner;

public class OutOfRange {
    public static int readNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input integer number from range [0,100]");
        return sc.nextInt();
    }

    public static boolean checkNumber(int n) {
        return n >= 0 && n <= 100;
    }

    public static void main(String[] args) {
        int num = 0;
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            num = readNumber();
            if (!checkNumber(num)) {
                System.out.println("the input number is out of range [0,100]");
                if (true)
                    return;
            }
            sum += num;

        }
        System.out.println("sum of input numbers from range [0,100]: " + sum);
    }
}