package com.aca.homework.week4.developer;

public class TestDeveloper {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setName("Gerard");
        developer.print();

        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
        juniorDeveloper.setName("Maricar");
        juniorDeveloper.print();

        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
        seniorDeveloper.setName("Emily");
        seniorDeveloper.print();
    }
}
