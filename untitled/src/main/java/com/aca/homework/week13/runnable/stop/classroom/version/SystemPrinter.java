package com.aca.homework.week13.runnable.stop.classroom.version;

public class SystemPrinter implements Printer {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}