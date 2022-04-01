package com.aca.homework.week11.occurence;

public class StringOfNumberSupplierTest implements Supplier<String> {
    private String[] inputs;
    private int index;

    public StringOfNumberSupplierTest(String[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public String get() {
        return inputs[index++];
    }
}