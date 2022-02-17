package com.aca.homework.week3.classroom;

public class AcaClass {

    Student[] students;
    long startMillis;
    long endMillis;
    String name;
    long fee;

    public void print() {
        System.out.println("AcaClass Name: " + name);
        System.out.println("AcaClass fee: " + fee);
        System.out.println("AcaClass start time by millis: " + startMillis);
        System.out.println("AcaClass end time by millis: " + endMillis);
        System.out.println("AcaClass name  surname  of students: ");
        for (int i = 0; i < students.length; i++) {
           students[i].print();
        }
    }
}
