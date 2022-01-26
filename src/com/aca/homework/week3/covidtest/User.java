package com.aca.homework.week3.covidtest;

public class User {
    String code;
    String name;

    public void print() {
        System.out.print("username:" + name + " usercode:" + code);
    }

    public String print1() {
        return name + "/" + code;
    }
}