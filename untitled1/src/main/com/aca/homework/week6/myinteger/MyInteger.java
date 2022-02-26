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
            System.out.println(value + " is out of range [-100,100] we can not cache it  with number in this range,needed another range for caching int values");
            return null;
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
