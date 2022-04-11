package com.aca.classroom.week6.set;

public abstract class AbstractSet implements Set {
    @Override
    public boolean isEmpty() {
        return size() == 0 ? true : false;
    }
}
