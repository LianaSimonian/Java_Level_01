package com.aca.classroom.week3.bank;

public class Bank {
    Account[] accounts;
    String name;

    public void print() {

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].print();
        }
        System.out.println(name);
    }

}
