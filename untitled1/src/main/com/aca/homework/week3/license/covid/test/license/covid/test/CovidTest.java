package com.aca.homework.week3.license.covid.test.license.covid.test;

import java.util.Random;

public class CovidTest {
    private User user;
    private String result;

    public CovidTest(User user) {
        this.user=user;
        result = "undefined";
    }

    public  void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getResult() {
        return result;
    }

    public void test() {
        long start = System.currentTimeMillis();
        String[] results = new String[]{"positive", "negative"};
        int randomInt = new Random().nextInt(2);
        result = results[randomInt];
        while (System.currentTimeMillis() - start < 3000) {
        }
    }
}
