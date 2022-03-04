package com.aca.classroom.week8.buffer.generic;

public class BufferImpl<T> implements Buffer<T> {
    T o;

    @Override
    public void put(T o) {
        this.o = o;
    }

    @Override
    public T get() {
        return o;
    }
}
