package com.aca.homework.week6.buffer;

import java.util.Objects;

public class BufferImpl implements Buffer {
    private Object item;

    @Override
    public void put(Object o) {
        if (item != null) {
            System.out.println("buffer is not empty");
            return;
        }
        item = o;
    }

    @Override
    public Object get() {
        if (item == null) {
            System.out.println("buffer is empty");
            return null;
        }
        Object deletedElem=item;
        item=null;
        return deletedElem;
    }

    @Override
    public String toString() {
        return (item != null) ? item.toString() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == BufferImpl.class) {
            return item.equals(((BufferImpl) o).item);
        }
        return false;
    }
}
