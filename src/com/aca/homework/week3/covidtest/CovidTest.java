package com.aca.homework.week3.covidtest;

public class CovidTest {
    //char result;
    String result;
    User user;

    public static void printCovidTest(CovidTest covidtest) {
        System.out.println("username:" + covidtest.user.name + " usercode:" +
                covidtest.user.code + " testresult:" + covidtest.result);

    }

    public void print() {
        user.print();
        System.out.println(" testresult:" + result);

    }

    public String print1() {
        return user.print1() + "/" + result;
    }
}

