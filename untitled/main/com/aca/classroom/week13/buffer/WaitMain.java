package com.aca.classroom.week13.buffer;

public class WaitMain {
    public static void main(String[] args) throws InterruptedException {
        WaitMain waitMain = new WaitMain();
        waitMain.wait(); // throws an exception because the lock is not in our hands
        waitMain.notifyAll(); // throws an exception because the lock is not in our hands
        //now Lock take main thread
        final WaitMain waitMain1 = new WaitMain();
        synchronized (waitMain1) {
            waitMain1.wait();
        }
    }
}
