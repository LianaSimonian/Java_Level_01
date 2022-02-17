package com.aca.classroom.week3.exam.exam1;

import java.util.Scanner;

public class Exam {
    public int maxOfNumbers(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        return max;
    }

    public int minOfNumbers(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public int[] duplicateOfNumbers(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 2 * numbers[i];
        }
        return numbers;
    }

    public double minValueOfNumbers(int[] numbers) {
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }

    public int differenceOfMinMax(int[] numbers) {
        System.out.println("difference of min end max:");
        return maxOfNumbers(numbers) - minOfNumbers(numbers);
    }

    public int countOfZerosInNumber(int number) {
        int count = 0;
        if (number == 0) return 1;
        while (number != 0) {

            if (number % 10 == 0) {
                count++;
            }
            number = (number - number % 10) / 10;
        }
        return count;
    }

    public int CountOfZeros(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            count += countOfZerosInNumber(numbers[i]);
        }
        return count;
    }

    public void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public void printNthNumber(int[] numbers) {
        System.out.println("input index of number");
        int n = new Scanner(System.in).nextInt();
        if (n >= 1 && n <= 5) {
            System.out.println(numbers[n - 1]);
        } else
            System.out.println("not find number of " + n + " index");
    }

}
