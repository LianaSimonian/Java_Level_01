package com.aca.homework.week9.donate;

public class Watch implements Donatable {
    private double price;

    public Watch(double price) {
        this.price = price;
    }

    @Override
    public double donationAmount() {
        return price * 0.05;
    }

    @Override
    public String toString() {
        return "Watch: " +
                "price=" + price;
    }
}
