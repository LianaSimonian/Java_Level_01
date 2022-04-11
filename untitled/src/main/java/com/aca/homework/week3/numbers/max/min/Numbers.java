package com.aca.homework.week3.numbers.max.min;

public class Numbers {
    private long number1;
    private long number2;
    private long number3;

    public Numbers(long number1, long number2, long number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public long getNumber1() {
        return number1;
    }

    public long getNumber2() {
        return number2;
    }

    public long getNumber3() {
        return number3;
    }

    public void setNumber1(long number1) {
        this.number1 = number1;
    }

    public void setNumber2(long number2) {
        this.number2 = number2;
    }

    public void setNumber3(long number3) {
        this.number3 = number3;
    }

    public long max() {
        long max = number1;

        if (max < number2) {
            max = number2;
        }

        if (max < number3) {
            max = number3;
        }

        return max;
    }

    public long min() {
        long min = number1;

        if (min > number2) {
            min = number2;
        }

        if (min > number3) {
            min = number3;
        }

        return min;
    }

    public void print() {
        System.out.println(number1 + " " + number2 + " " + number3);
    }
}

