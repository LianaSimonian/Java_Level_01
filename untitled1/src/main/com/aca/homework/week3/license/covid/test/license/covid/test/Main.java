package com.aca.homework.week3.license.covid.test.license.covid.test;

public class Main {
    public static void main(String[] args) {
        User user = new User("vova_gasparyan", "Vova");

        CovidTest covidTest = new CovidTest(user);

        char[] dlOfUser = {'B', 'C'};
        DrivingLicense drivingLicense = new DrivingLicense(user, dlOfUser);

        System.out.println("driving license of " + user.getName() + " is ");
        System.out.println(drivingLicense.getDrivingLicense());

        System.out.println("Result before giving a test:");
        System.out.println(covidTest.getResult());

        covidTest.test();

        System.out.println("Result after giving a test:");
        System.out.println(covidTest.getResult());
    }
}
