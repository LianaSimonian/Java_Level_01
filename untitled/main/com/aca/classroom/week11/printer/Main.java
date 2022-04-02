package com.aca.classroom.week11.printer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
        if (true) {
            throw new RuntimeException();
        }
 */
        String folderPath = "D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\com\\aca\\classroom\\week11\\printer";
        final long start = System.currentTimeMillis();
        List<Runnable> runnables = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            runnables.add(new FilePrinterRunnable(folderPath + "aca-txt-" + i + ".txt"));
        }

        for (final Runnable runnable : runnables) {
            new Thread(runnable).start();
            //runnable.run();
        }

        System.out.println(System.currentTimeMillis() - start);

        for (int i = 0; i < 10; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    while (System.currentTimeMillis() - start < 3000) ;
                }
            }).start();

        /*
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
        */
        //list.fori//hot key
    }
}