package com.aca.classroom.week13.buffer;

public interface Buffer<T> {

    T get() throws InterruptedException;

    void put(T value) throws InterruptedException;
}
