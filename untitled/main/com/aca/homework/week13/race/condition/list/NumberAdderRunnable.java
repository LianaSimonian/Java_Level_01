package com.aca.homework.week13.race.condition.list;

public class NumberAdderRunnable implements Runnable {

    private List<Integer> list;
    private Integer integer;

    public NumberAdderRunnable(List<Integer> list, Integer integer) {
        this.list = list;
        this.integer = integer;
    }

    @Override
    public void run() {
        list.add(integer);
    }
}