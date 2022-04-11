package com.aca.classroom.week13.buff;

public final class UnsafedBuffer<T> implements Buffer<T> {
    //Safe
    private T value;

    @Override
    public T get() {
        if (value == null) {
            throw new IllegalStateException("the buffer is empty");
        }
        T valueToReturn = value;
        value = null;
        notifyAll();
        return valueToReturn;
    }

    @Override
    public void put(final T t)throws InterruptedException {
        if (value == null) {
            throw new IllegalArgumentException("the provided value is null");
        }/*
        if (value != null) {
            throw new IllegalStateException("the buffer is full");
        }
        */
        if(value!=null){
            wait();
        }
        this.value = t;

    }

}
