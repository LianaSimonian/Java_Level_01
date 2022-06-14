package com.aca.homework.week14.thread.interrupt;

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

                sharedList.add(UUID.randomUUID().toString());

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}