package com.aca.homework.week13.runnable.stop;

import java.util.function.Consumer;

public class ConsumerForTest implements Consumer<String> {

    private int callsNumber;
    private String string = null;

    @Override
    public void accept(String s) {
        callsNumber++;
        if (string == null)
            string = s;
    }

    public int getCallsNumber() {
        return callsNumber;
    }

    public String getString() {
        return string;
    }
}