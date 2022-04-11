package com.aca.homework.week13.consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class PrinterConsumerForTest implements Consumer<String> {

    private List<String> argumentsList = new LinkedList<>();
    private int callsNumber;

    @Override
    public void accept(String s) {
        callsNumber++;
        argumentsList.add(s);
    }

    public int getCallsNumber() {
        return callsNumber;
    }

    public List<String> getArgumentsList() {
        return argumentsList;
    }
}
