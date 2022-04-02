package com.aca.classroom.week12.functional;

public class IntegerSupplier implements Supplier<Integer> {
    @Override
    public Integer get() {
        //AUTO BOXING -primitive to object
        return Integer.valueOf(8);
    }
    //intSupplier//works with int
    //LongSupplier//work with primitive long
    //functional interface
}