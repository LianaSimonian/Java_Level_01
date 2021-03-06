package com.aca.homework.week13.race.condition.list;

public interface List<E> {

    void add(E item);

    int size();

    E get(int index);

    boolean contains(E item);
}