package com.aca.classroom.week6;

public class ArrayBuffer implements Buffer {
    private String[] array = new String[1];

    @Override
    public void put(String value) {
        array[0] = value;
    }

    public String get() {
        return array[0];
    }

}
