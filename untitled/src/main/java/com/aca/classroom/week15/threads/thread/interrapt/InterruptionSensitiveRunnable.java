package com.aca.classroom.week15.threads.thread.interrapt;

import java.util.List;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class InterruptionSensitiveRunnable implements Runnable {

    private final List<String> sharedList;

    public InterruptionSensitiveRunnable(List<String> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) return;

            synchronized (sharedList) {
                sharedList.add(UUID.randomUUID().toString());
            }
// List<String> sharedList = Collections.synchronizedList(new LinkedList<>()); synchronized lav chi
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
