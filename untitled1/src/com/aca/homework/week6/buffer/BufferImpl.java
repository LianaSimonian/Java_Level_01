package com.aca.homework.week6.buffer;

import java.util.Objects;

public class BufferImpl implements Buffer {
    private Object item;
    private int counter;

    @Override
    public void put(Object o) {
        if (counter == 1) {
            System.out.println("buffer is not empty");
            return;
        }
        item = o;
        counter++;
    }

    @Override
    public Object get() {
        if (counter == 0) {
            System.out.println("buffer is empty");
            return null;
        }
        counter--;
        return item;

    }

    @Override
    public String toString() {
        if (counter == 1)
            return item.toString();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == BufferImpl.class) {
            return counter == ((BufferImpl) o).counter && item.equals(((BufferImpl) o).item);
        }
        return false;
    }
}
