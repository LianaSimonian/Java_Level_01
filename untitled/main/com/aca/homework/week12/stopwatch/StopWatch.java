package com.aca.homework.week12.stopwatch;


public class StopWatch {

    private final DisplayType type;
    protected long timer;

    public StopWatch(DisplayType type) {
        this.type = type;
    }

    public void start() {
        long startMillis;
        while (true) {
            System.out.println(type.displayFormat(timer));
            startMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - startMillis < 10) ;
            timer += 10;
        }
    }

    public long getTimer() {
        return timer;
    }
}