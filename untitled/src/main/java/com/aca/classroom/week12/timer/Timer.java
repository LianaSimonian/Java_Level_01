package com.aca.classroom.week12.timer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class Timer {
    boolean isRunning = true;//volatile

    public void start() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (isRunning) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println(i++);
                    //System.out.println(i++);
                }
            }
        }).start();
    }

    void stop() {
        isRunning = false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setErr(new PrintStream("D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\com\\aca\\classroom\\week12\\timer\\file2.txt"));
        final Timer timer = new Timer();
        timer.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input number");
            int number = scanner.nextInt();
            if (number == -1) {
                timer.stop();
                break;
            }
        }
    }
    //System.in
    //System.err
    //System.out
}
//hot key//ctrl+alt+b