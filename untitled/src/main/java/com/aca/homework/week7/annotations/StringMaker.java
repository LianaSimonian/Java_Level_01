package com.aca.homework.week7.annotations;

public interface StringMaker {
    StringMakerResult make(int start, int end);

    static StringMaker ofBad() {
        return new StringMakerImpl();
    }

    static StringMaker ofGood() {
        return new GoodStringMaker();
    }
}

