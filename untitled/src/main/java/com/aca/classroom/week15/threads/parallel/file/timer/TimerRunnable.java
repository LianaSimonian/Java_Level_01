package com.aca.classroom.week15.threads.parallel.file.timer;

import java.io.*;

public class TimerRunnable implements Runnable {

    private final static String PATH = "D:\\Users\\user\\IdeaProjects\\aca2\\Java_Level_01\\untitled\\src\\main\\java\\com\\aca\\homework\\week14\\parallel\\file\\timer\\";
    private final String filename;
    private boolean isRunning = true;

    TimerRunnable(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH + filename + ".txt"));
            } catch (IOException e) {
                throw new RuntimeException("Error trying to write in file with path: " + PATH + filename + ".txt", e);
            }

            try {
                objectOutputStream.writeLong((System.currentTimeMillis() - start) / 1000);
            } catch (IOException e) {
                throw new RuntimeException("write error in file with path: " + PATH + filename + ".txt", e);
            }

            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    public String getFilename() {
        return filename;
    }
}
