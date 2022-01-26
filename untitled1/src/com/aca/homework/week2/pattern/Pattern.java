package com.aca.homework.week2.pattern;

import java.util.Scanner;

public class Pattern{
    public static void print(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void addPattern3Right(char[][] matrix, int i, int j) {

        if ((j + 3) > matrix[i].length) {
            System.out.println("Input error:out of bounds of  matrix");
            return;
        }
        for (int c = j; c < j + 3; c++)
            matrix[i][c] = '*';
    }

    public static void addPattern2Right2Top(char[][] matrix, int i, int j) {
        if ((i - 2) < 0 || (j + 1) >= matrix[i].length) {
            System.out.println("Input error:out of bounds matrix");
            return;
        }
        for (int c = j; c < j + 2; c++) {
            matrix[i][c] = '*';
        }
        for (int c = i - 1; c > i - 3; c--)
            matrix[c][j + 1] = '*';
    }

    ;

    public static void main(String[] args) {
        char[][] matrix = new char[5][5];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = '0';
            }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write 1 to use addPattern3Right and 2 for addPattern2Right2Top");
        int number = sc.nextInt();
        if (number == 1) {
            System.out.println("Please write the i");
            int i =sc.nextInt();
            if(i<0 || i>=matrix.length ){
                System.out.println("Input error:i is out of bounds   matrix ");
                return;
            }
            System.out.println("Please write the j");
            int j = sc.nextInt();
            if( j<0 ||j>=matrix[i].length){
                System.out.println("Input error:j is out of bounds of  matrix ");
                return;
            }
            System.out.println("before");
            print(matrix);
            System.out.println("after");
            addPattern3Right(matrix, i, j);
            print(matrix);
        } else {
            if (number == 2) {
                System.out.println("Please write the i");
                int i =sc.nextInt();
                System.out.println("Please write the j");
                int j = sc.nextInt();
                System.out.println("before");
                print(matrix);
                addPattern2Right2Top(matrix, i, j);
                System.out.println("After");
                print(matrix);
            }
            else {
                System.out.println("you entered a number different from 1 and 2");
            }
        }
    }
}