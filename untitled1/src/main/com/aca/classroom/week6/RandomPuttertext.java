package com.aca.classroom.week6;

import java.util.Scanner;

public class RandomPuttertext {
    public static void main(String[] args) {

        new RandomPutter(new MyBuffer()).start();
        int i = new Scanner(System.in).nextInt();
        Buffer buffer = getBuffer(i);

    }

    public static Buffer getBuffer(int i) {
        return (i == 0) ? new MyBuffer() : new ArrayBuffer();
    }

}
