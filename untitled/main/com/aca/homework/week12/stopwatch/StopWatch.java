package com.aca.homework.week12.stopwatch;


public class StopWatch {
    private final DisplayType type;
    protected long timer;

    public StopWatch(DisplayType type) {
        this.type = type;
    }

    public void start() {
        while (true) {
            System.out.println(type.displayFormat(timer));
            wait10Millis();
            timer += 10;
        }
    }

    private void wait10Millis() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 10) ;
    }

    public long getTimer() {
        return timer;
    }
}