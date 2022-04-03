package com.aca.homework.week13.race.condition.list;

public class NumberAdderRunnable implements Runnable {

    List<Integer> list;
    Integer integer;

    public NumberAdderRunnable(List<Integer> list, Integer integer) {
        this.list = list;
        this.integer = integer;
    }

    @Override
    public void run() {
        list.add(integer);
    }
}