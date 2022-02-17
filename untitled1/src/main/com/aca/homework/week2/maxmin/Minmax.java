package com.aca.homework.week2.maxmin;

import java.util.Scanner;

public class Minmax {
    public static Maxmin createMaxMin(long a, long b) {
        //using default constructor
        Maxmin temp = new Maxmin();
        temp.min = a > b ? b : a;
        temp.max = a > b ? a : b;
        return temp;

    }

    public static Maxmin createMaxMin1(long a, long b) {
        return new Maxmin(a, b);
    }

    public static long[] inputTwoNumbers() {
        long[] numbers = new long[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("input two long numbers:");
        numbers[0] = sc.nextLong();
        numbers[1] = sc.nextLong();
        return numbers;
    }

    public static void main(String[] args) {
        Maxmin maxmin = new Maxmin(12, 4);
        maxmin.printmaxMin();//version1
        printmaxMin(maxmin);//version2
        Printers.printmaxMin(maxmin);

        System.out.println();
        Maxmin[] maxMins = get3MaxMins();
        printMaxMins(maxMins);

    }

    public static Maxmin[] get3MaxMins() {
        Maxmin[] maxMinArray = new Maxmin[3];

        for (int i = 0; i < 3; i++) {
            long[] numbers = inputTwoNumbers();
            maxMinArray[i] = createMaxMin(numbers[0], numbers[1]);
        }
        return maxMinArray;
    }

    public static void printMaxMins(Maxmin[] maxmins) {
        for (int i = 0; i < maxmins.length; i++) {
            maxmins[i].printmaxMin();
        }
    }

    public static void printmaxMin(Maxmin maxmin) {
        System.out.println("the max is :" + maxmin.max + " the min is:" + maxmin.min);
    }

}
