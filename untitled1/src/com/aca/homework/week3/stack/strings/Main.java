package com.aca.homework.week3.stack.strings;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        try {
            System.out.println("is stack empty?:" + stack.isEmpty());
            stack.push("main");
            stack.push("push");
            stack.push("push");
            stack.push("push");

            System.out.println("top:" + stack.getTop());
            System.out.println("size:" + stack.sizeOfStack());

            for (int i = 0; i < 4; i++) {
                System.out.println("removed value:"+ stack.pop());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("size:" + stack.sizeOfStack());
    }
}
