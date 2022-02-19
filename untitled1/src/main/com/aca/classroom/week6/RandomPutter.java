package com.aca.classroom.week6;

import java.util.Scanner;

public class RandomPutter {
    private Buffer buffer;

    public RandomPutter(Buffer buffer) {
        creater();
    }

    private void creater() {
        int i = new Scanner(System.in).nextInt();
        if (i == 0)
            buffer = new MyBuffer();
        if (i == 1)
            buffer = new ArrayBuffer();
    }

    public void start() {

        for (int i = 0; ; i += 2) {
            buffer.put("text" + i);
            wait1Sec();
            System.out.println(buffer.get());
            wait1Sec();
        }

    }

    public static void wait1Sec() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {

        }
    }
}
