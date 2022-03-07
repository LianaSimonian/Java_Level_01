package com.aca.homework.week9.calculator.simple;

import java.util.Scanner;

public class SimpleCalculator {
    private StringSupplier stringSupplier;

    public SimpleCalculator(StringSupplier stringSupplier) {
        this.stringSupplier = stringSupplier;
    }

    public String askAndCalculate() {
        String expression = stringSupplier.get();

        int lengthOfExpression = expression.length();
        if (lengthOfExpression != 3) {
            System.out.println("The user input expression having other format then \' digit operation digit \' ");
            return "error";
        }

        char operation = expression.charAt(1);
        int firstOperand = convertCharToDigit(expression.charAt(0));
        int secondOperand = convertCharToDigit(expression.charAt(2));

        if (isCharOperation(operation) && firstOperand != -1 && secondOperand != -1) {
            switch (operation) {
                case '+': {
                    String result = Integer.toString(firstOperand + secondOperand);
                    System.out.println("result = " + result);
                    return result;
                }
                case '*': {
                    String result = Integer.toString(firstOperand * secondOperand);
                    System.out.println("result = " + result);
                    return result;
                }
                case '/': {
                    String result = Double.toString((double) firstOperand / secondOperand);
                    System.out.println("result = " + result);
                    return result;
                }
                case '-': {
                    String result = Integer.toString(firstOperand - secondOperand);
                    System.out.println("result = " + result);
                    return result;
                }
            }
        }
        System.out.println("The user input expression having other format then \' digit operation digit \' ");
        return "error";
    }

    private static int convertCharToDigit(char digit) {
        if (digit < '0' || digit > '9') return -1;
        return digit - 48;
    }

    private static boolean isCharOperation(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

    public static void main(String[] args) {
        new SimpleCalculator(new UserInputStringSupplier()).askAndCalculate();
    }
}