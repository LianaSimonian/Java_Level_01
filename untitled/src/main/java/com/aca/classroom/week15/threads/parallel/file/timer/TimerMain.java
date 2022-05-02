package com.aca.classroom.week15.threads.parallel.file.timer;

import java.io.*;
import java.util.function.Supplier;

public class TimerMain {

    private final static String PATH = "D:\\Users\\user\\IdeaProjects\\aca2\\Java_Level_01\\untitled\\src\\main\\java\\com\\aca\\homework\\week14\\parallel\\file\\timer\\";
    private final Supplier<String> supplier;

    public TimerMain(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    public void startTimer() {
        System.out.println("please input first filename for starting timer ");
        TimerRunnable timer1 = new TimerRunnable(supplier.get());
        new Thread(timer1).start();

        System.out.println("please input second filename for starting timer ");
        TimerRunnable timer2 = new TimerRunnable(supplier.get());
        new Thread(timer2).start();

        System.out.println("please input filename for stopping timer ");
        if (timer1.getFilename().equals(supplier.get())) timer1.stop();
        else timer2.stop();

        System.out.println("please input filename for stopping timer ");
        if (timer2.getFilename().equals(supplier.get())) timer2.stop();
        else timer1.stop();

    }

    public static long getSecondsFromFile(String filename) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(PATH + filename + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException("failed input from file with path: " + PATH + filename + ".txt", e);
        }
        long second = 0;
        try {
            second = objectInputStream.readLong();
        } catch (IOException e) {
            throw new RuntimeException("failed input from file with path: " + PATH + filename + ".txt", e);
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return second;
    }

    public static void main(String[] args) {
        new TimerMain(new StringSupplier()).startTimer();
    }
}