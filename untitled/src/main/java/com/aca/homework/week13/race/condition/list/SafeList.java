package com.aca.homework.week13.race.condition.list;

import java.util.ArrayList;

public class SafeList<E> implements List<E> {

    private java.util.List<E> list = new ArrayList<>();

    @Override
    public synchronized void add(E item) {
        list.add(item);
    }

    @Override
    public synchronized int size() {
        return list.size();
    }

    @Override
    public synchronized E get(int index) {
        return list.get(index);
    }

    @Override
    public synchronized boolean contains(E item) {
        return list.contains(item);
    }
}