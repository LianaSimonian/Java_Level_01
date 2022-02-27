package com.aca.homework.week6.myinteger;

public class MyInteger {
    private static MyInteger[] myIntegers = new MyInteger[201];
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MyInteger valueOf(int value) {
        if (isValueOutOfRange(value)) {
            return new MyInteger(value);
        }
        if (myIntegers[value + 100] == null) {
            myIntegers[value + 100] = new MyInteger(value);
        }
        return myIntegers[value + 100];
    }

    public static boolean isValueOutOfRange(int value) {
        return value < -100 || value > 100;
    }
}
