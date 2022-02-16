package com.aca.homework.week6.buffer;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new BufferImpl();
        buffer.put("text");
        buffer.put("text1");

        System.out.println(buffer.get());
        buffer.get();

        buffer.put("text2");
        System.out.println(buffer.toString());

        Buffer buffer1 = new BufferImpl();
        buffer1.put("text2");
        System.out.println(buffer1.equals(buffer));
        System.out.println(buffer1.equals("hello"));
    }
}
