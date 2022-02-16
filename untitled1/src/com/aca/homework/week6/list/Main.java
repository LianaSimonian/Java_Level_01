package com.aca.homework.week6.list;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < list.getLength(); i++) {
            list.add("text" + i);
        }
        list.add("***");
        for (int i = 0; i < list.getNumberOfElements(); i++) {
            System.out.println(list.get(i));
        }
    }
}
