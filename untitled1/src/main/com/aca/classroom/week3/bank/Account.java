package com.aca.classroom.week3.bank;

public class Account {
    double money;

    public void zeroMoney() {
        money = 0;
    }

    public void print() {
        System.out.println(money);
    }

    public double increaseOnePercent() {
        money = 1.01 * money;
        return money;
    }

    public static void main(String[] args) {

        Bank bank = new Bank();

        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].money = 15000 * (i + 1);
        }
        bank.accounts = accounts;
        bank.name = "ASBC";

        bank.print();
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j <= 365; j++) {
                accounts[i].increaseOnePercent();
            }
        }
        bank.print();
    }
}
