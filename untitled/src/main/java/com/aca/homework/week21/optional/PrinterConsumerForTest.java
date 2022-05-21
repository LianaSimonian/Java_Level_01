package com.aca.homework.week21.optional;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class PrinterConsumerForTest implements Consumer<Character> {

    private Character symbol;
    private int callsNumber;

    @Override
    public void accept(Character s) {
        callsNumber++;
        symbol = s;
    }

    public int getCallsNumber() {
        return callsNumber;
    }

    public Character getSymbol() {
        return symbol;
    }
}
