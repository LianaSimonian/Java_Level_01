package com.aca.homework.week13.race.condition.list;

import java.util.ArrayList;

public class UnsafeList<E> implements List<E> {

    private java.util.List<E> list = new ArrayList<>();

    @Override
    public void add(E item) {
        list.add(item);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public boolean contains(E item) {
        return list.contains(item);
    }
}