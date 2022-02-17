package com.aca.homework.week5.exam;

public class Main {
    public static void main(String[] args) {
        ExamTest object1 = new FailedExamTest("username1");
        ExamTest object2 = new PassedExamTest("smart_username");

        object1.print();
        object2.print();
    }
}
