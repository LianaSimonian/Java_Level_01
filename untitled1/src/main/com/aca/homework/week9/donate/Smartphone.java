package com.aca.homework.week9.donate;

public class Smartphone implements Donatable {
    private double price;

    public Smartphone(double price) {
        this.price = price;
    }

    @Override
    public double donationAmount() {
        return price * 0.05;
    }

    @Override
    public String toString() {
        return "SmartPhone: " +
                "price=" + price;
    }
}
