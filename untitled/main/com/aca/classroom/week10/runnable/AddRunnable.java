package com.aca.classroom.week10.runnable;

public class AddRunnable implements Runnable {
    private int number1;
    private int number2;

    public AddRunnable(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public void run() {
        System.out.println(number1 + number2);
    }

    public int sum() {
        return number1 + number2;
    }
}
