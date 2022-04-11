package com.aca.classroom.week8.scanner;

public class IntSupplierForTest2version extends IntSupplier{
    private int elements[];
    private int index;

    public IntSupplierForTest2version(int[] elements) {
        this.elements = elements;
    }
    public int get(){
        return elements[index++];
    }
}
