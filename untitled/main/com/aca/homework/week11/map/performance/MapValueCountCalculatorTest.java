package com.aca.homework.week11.map.performance;

import java.util.Scanner;

public class MapValueCountCalculatorTest {
    public static void main(String[] args) {
        System.out.println("please input MapValueCountCalculator instance type ('low' or 'high')");
        String input = new Scanner(System.in).nextLine();
        while (!input.equals("low") && !input.equals("high")) {
            System.out.println("please input correct value ('low' or 'high') for MapValueCountCalculator instance type ");
            input = new Scanner(System.in).nextLine();
        }
        MapValueCountCalculator calculator = null;
        if (input.equals("low")) {
            calculator = new LowPerformanceMapValueCountCalculator();
        } else {
            calculator = new HighPerformanceMapValueCountCalculator();
        }
        System.out.println("please input value for  number Of Random Strings");
        int numberOfRandomStrings = new Scanner(System.in).nextInt();
        long startTime = System.currentTimeMillis();
        MinMaxOccurrence result = calculator.populateAndCalculate(numberOfRandomStrings);
        System.out.println("populateAndCalculate() processing time: " + (System.currentTimeMillis() - startTime));
        System.out.print("populateAndCalculate() result:");
        result.print();
    }
}