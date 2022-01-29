package com.aca.homework.week3.numbers.max.min;

public class Numbers_Test {
    public static void main(String[] args) {
        Numbers numbers = new Numbers(2,25,14);

        numbers.print();
        System.out.println("max of numbers " + numbers.getNumber1()+  " " +numbers.getNumber2() + " " + numbers.getNumber3() +
                " is equal to " + numbers.max());
        System.out.println("min of numbers " + numbers.getNumber1()+  " " +numbers.getNumber2() + " " + numbers.getNumber3() +
                " is equal to " + numbers.min());

    }
}
