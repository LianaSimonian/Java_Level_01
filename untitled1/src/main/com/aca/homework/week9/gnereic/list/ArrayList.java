package com.aca.homework.week9.gnereic.list;

public class ArrayList<E> implements List<E> {
    private final int size = 1000;
    private Object[] array = new Object[size];
    private int counter;

    @Override
    public void add(E element) {
        array[counter++] = element;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= counter) throw new ArrayListIndexOutOfBoundsException(index);
        return (E) array[index];
    }

    @Override
    public int size() {
        return counter;
    }

}

