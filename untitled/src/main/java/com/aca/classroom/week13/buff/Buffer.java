package com.aca.classroom.week13.buff;

public interface Buffer<T> {

    T get();

    void put(T t) throws InterruptedException;
}
