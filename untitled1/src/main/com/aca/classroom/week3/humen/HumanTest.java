package com.aca.classroom.week3.humen;

public class HumanTest {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.setHeight(45);
        human1.setName("Jane");

        Human human2 = new Human();
        human2.setHeight(470);
        human2.setName("Alex");

        System.out.println(human1.getStringRepresentation());

    }
}
