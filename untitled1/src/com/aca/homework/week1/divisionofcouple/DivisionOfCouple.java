package com.aca.homework.week1.divisionofcouple;

import java.util.Scanner;

public class DivisionOfCouple {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("input arr[" + i + "] ");
            Scanner sc = new Scanner(System.in);
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("division of (" + i + "," + j + ") couple is equal to " + arr[i] / arr[j]);
            }

    }
}
