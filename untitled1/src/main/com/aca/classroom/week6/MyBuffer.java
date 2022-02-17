package com.aca.classroom.week6;

public class MyBuffer implements Buffer {
    private String value;

    public void put(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

}
