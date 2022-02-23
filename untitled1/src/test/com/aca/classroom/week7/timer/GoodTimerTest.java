package com.aca.classroom.week7.timer;


class GoodTimerTest {
    public static void main(String[] args) {
        //anonymous implementation,class
        Timer timer = new GoodTimer(new Action() {
            @Override
            public void doAction() {
                System.out.println("hello");
            }
        });

        //anonymous implementation,class
        timer.start();
        Timer timer1 = new GoodTimer(new HelloPrinterAction());

    }
}