package com.aca.homework.week2.maxmin;

public class Maxmin {
    long min;
    long max;

    Maxmin() {

    }

    Maxmin(long m1, long m2) {
        if (m1 > m2) {
            max = m1;
            min = m2;
        } else {
            max = m2;
            min = m1;
        }
    }

    public void printmaxMin() {
        System.out.println("the max is :" + max + " the min is:" + min);
    }
}
