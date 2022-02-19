package com.aca.homework.week2.symbolcount;

import java.util.Scanner;

public class SymbolCount {
    public static int numberSymbolsInText(String str, int ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println("please write a text");
        String text = new Scanner(System.in).nextLine();
        System.out.println("please write a symbol");
        int symbol = new Scanner(System.in).next().charAt(0);
        System.out.println(numberSymbolsInText(text, symbol));

    }
}