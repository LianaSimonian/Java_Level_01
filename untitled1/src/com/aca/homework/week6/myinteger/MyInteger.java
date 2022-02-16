package com.aca.homework.week6.myinteger;

public class MyInteger {
    private static MyInteger[] myIntegers = new MyInteger[201];
    private static boolean[] integerValues = new boolean[201];
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MyInteger valueOf(int value) {
        if (integerValues[value + 100] == false) {
            myIntegers[value + 100] = new MyInteger(value);
            integerValues[value + 100] = true;
        }
        return myIntegers[value + 100];
    }

    public static void main(String[] args) {

        System.out.println(valueOf(17).getValue());
        System.out.println(valueOf(10).getValue());
        System.out.println(valueOf(17).getValue());
        System.out.println(valueOf(10).getValue());
        System.out.println(valueOf(20).getValue());
        System.out.println(valueOf(10).getValue());
        System.out.println(valueOf(10).getValue());


    }


}