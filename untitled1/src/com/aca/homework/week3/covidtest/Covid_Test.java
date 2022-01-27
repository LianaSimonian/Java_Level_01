package com.aca.homework.week3.covidtest;

public class Covid_Test {
    public static void main(String[] args) {

        User user1 = new User();
        user1.name = "Mark";
        user1.code = "mark789";

        User user2 = new User();
        user2.name = "Jane";
        user2.code = " jane45";

        User user3 = new User();
        user3.name = "Kate";
        user3.code  = "kate876&";

        CovidTest covidTestOfUser1 = new CovidTest();
        covidTestOfUser1.result = "positive";
        covidTestOfUser1.user = user1;

        CovidTest covidTestOfUser2 = new CovidTest();
        covidTestOfUser2.result =" positive";
        covidTestOfUser2.user = user2;

        CovidTest covidTestOfUser3 = new CovidTest();
        covidTestOfUser3.result = "negative";
        covidTestOfUser3.user =user3;


        CovidTest. printCovidTest(covidTestOfUser1);
        CovidTest.printCovidTest(covidTestOfUser2);
        CovidTest.printCovidTest(covidTestOfUser3);
        System.out.println();

        covidTestOfUser1.print();
        covidTestOfUser2.print();
        covidTestOfUser3.print();
    }
}
