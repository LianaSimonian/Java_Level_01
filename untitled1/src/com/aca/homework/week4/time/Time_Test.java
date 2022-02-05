package com.aca.homework.week4.time;

public class Time_Test {
    public static void main(String[] args) {
        Time time = new Time();
        time.print();

        Time time0 = new Time(2 * 3600 + 5 * 60 + 6);
        time0.print();

        Time time1 = new Time(14 * 3600 + 5 * 60 + 6);
        time1.print();

        Time time2 = new Time(49 * 3600 + 10 * 60 + 15);
        time2.print();

        Time time3 = new Time(24 * 60 * 60);
        time3.print();

        Time time4 = new Time(12 * 3600 + 15 * 60 + 16);
        time4.print();


    }
}
