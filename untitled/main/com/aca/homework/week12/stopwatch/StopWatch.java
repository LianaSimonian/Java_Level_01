package com.aca.homework.week12.stopwatch;


public class StopWatch {

    private final DisplayType type;
    protected long timer;

    public StopWatch(DisplayType type) {
        this.type = type;
    }

    public void start() {
        long startMethodInvocationMillis;
        while (true) {
            System.out.println(type.displayFormat(timer));
            startMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - startMethodInvocationMillis < 10) ;
            timer += System.currentTimeMillis() - startMethodInvocationMillis ;
        }
    }

    public long getTimer() {
        return timer;
    }
}