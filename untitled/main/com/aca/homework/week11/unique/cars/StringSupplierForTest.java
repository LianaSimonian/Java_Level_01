package com.aca.homework.week11.unique.cars;

public class StringSupplierForTest implements Supplier<String> {
    private String[] strings;
    private int index;

    public StringSupplierForTest(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String get() {
        return strings[index++];
    }
}
