package com.aca.classroom.week5;

public class MyInteger {
    private int value;
    public MyInteger(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyInteger{" +
                "value=" + value +
                '}';
    }
}
