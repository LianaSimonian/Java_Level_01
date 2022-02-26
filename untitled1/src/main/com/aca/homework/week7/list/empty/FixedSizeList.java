package com.aca.homework.week7.list.empty;

public class FixedSizeList implements List {
    private final int size = 10;
    private Object[] array = new Object[size];
    private int currentSize;

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void add(Object o) {
        if (currentSize >= size) {
            System.err.println("The list is full");
            return;
        }
        array[currentSize++] = o;
    }

    @Override
    public boolean isEmpty() {
        return (currentSize == 0) ? true : false;
    }

    @Override
    public Object get(int index) {
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException();

        return array[index];
    }

    public boolean isValidIndex(int index) {
        return (index < 0 || index >= size) ? false : true;
    }
}
