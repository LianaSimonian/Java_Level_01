package com.aca.classroom.week6;

public class BufferTest {
    public static void main(String[] args) {

        Buffer buffer = new MyBuffer();
        buffer.put("text");
        System.out.println(buffer.get());
        Buffer buffer1 = new ArrayBuffer();
        buffer1.put("text");
        System.out.println(buffer1.get());
        printBufferValue(buffer);
        putInBuffer(buffer, "text");
        printBufferValue(buffer1);
        putInBuffer(buffer1, "text");
    }

    public static void putInBuffer(Buffer buffer, String value) {
        buffer.put(value);
    }

    public static void printBufferValue(Buffer buffer) {
        System.out.println(buffer.get());
    }
    //item 64
}
