package com.aca.checking1.ifelseperformance;

public class IfElsePerformance {
    public static long minWithoutElse(int number1, int number2, int number3) {
        long min = number1;

        if (min > number2) {
            min = number2;
        }

        if (min > number3) {
            min = number3;
        }

        return min;
    }

    public static long minWithElse(int number1, int number2, int number3) {
        long min = number1;

        if (min > number2) {
            min = number2;
        } else {
            if (min > number3) {
                min = number3;
            }
        }

        return min;
    }

    public static void operationsPerSecondsWithElse() {
        long count = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            count++;
            minWithElse(3, 2, 1);
        }
        System.out.println(count);
    }

    public static void operationsPerSecondsWithoutElse() {
        long count = 0;
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            count++;
            minWithoutElse(3, 2, 1);
        }
        System.out.println(count);
    }
}
