package com.aca.classroom.week3.exam.exam1;

import java.util.Scanner;

public class Exam_Test {
    public static void main(String[] args) {
        Exam exam = new Exam();
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter number:");
            numbers[i] = new Scanner(System.in).nextInt();
        }
        while (true) {
            System.out.println("enter step:");
            int number = new Scanner(System.in).nextInt();
            if (number == 1) {
                System.out.println(" max is:" + exam.maxOfNumbers(numbers));

            }
            if (number == 2) {
                System.out.println("min is:" + exam.minOfNumbers(numbers));
            }
            if (number == 3) {
                exam.duplicateOfNumbers(numbers);
                exam.printNumbers(numbers);
            }
            if (number == 4) {
                System.out.println(" min value :" + exam.minValueOfNumbers(numbers));

            }
            if (number == 5) {
                exam.printNthNumber(numbers);
            }
            if (number == 6) {
                System.out.println(exam.differenceOfMinMax(numbers));

            }
            if (number == 7) {
                System.out.println(exam.CountOfZeros(numbers));
            }
            if (number == 8) {
                return;
            }
            if (number > 8 || number < 0) {
                System.out.println("step number is invalid:");
            }
        }
    }
}
