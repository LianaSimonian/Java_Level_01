package com.aca.classroom.week8.scanner;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntScanner {
    private IntSupplier intSupplier;

    public IntScanner(IntSupplier intSupplier) {
        this.intSupplier = intSupplier;
    }

    public int[] get5SizedArray() {
        int[] array = new int[5];
        int i = 0;
        while (i < 5) {
            try {
                array[i] = intSupplier.get();
                i++;
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    public int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < 5; i++)
            if (max < array[i])
                max = array[i];
        return max;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntScanner(new IntSupplierForTest()).get5SizedArray()));
    }
}
