package com.aca.homework.week9.observable.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayObservableList<T> implements ObservableList<T> {
    private final int MAX_SIZE = 100_000;
    private Object[] objects = new Object[MAX_SIZE];
    private int counter;
    private int counterOfListeners;
    private List<ListChangeListener<T>> listOfListeners = new ArrayList<>();

    @Override
    public void add(T object) {
        if (object == null) throw new IllegalArgumentException("object is null");
        if (counter >= MAX_SIZE) throw new ArrayStoreException("arraylist is full");
        objects[counter++] = object;
        for (int i = 0; i < counterOfListeners; i++)
            listOfListeners.get(i).onAdded(object);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > MAX_SIZE)
            throw new IllegalArgumentException("index is negative");
        return (T) objects[index];
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void addListener(ListChangeListener<T> listener) {
        listOfListeners.add(listener);
        counterOfListeners++;
    }
}