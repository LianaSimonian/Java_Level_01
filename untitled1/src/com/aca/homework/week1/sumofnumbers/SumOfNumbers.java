package com.aca.homework.week1.sumofnumbers;


import java.util.Scanner;

public class SumOfNumbers{
    public static void main(String[] args) {
        int[] arr = new int[100];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("input array[" + i + "] ellem of type int:");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum of array is equal :" + sum);
    }
}
