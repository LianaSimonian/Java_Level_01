package com.aca.homework.week9.donate;

public class SmartWatch implements Donatable {
    private double price;

    public SmartWatch(double price) {
        this.price = price;
    }

    @Override
    public double donationAmount() {
        return price * 0.05;
    }

    @Override
    public String toString() {
        return "SmartWatch: " +
                "price=" + price;
    }

    public static void main(String[] args) {
        System.out.println(new SmartWatch(200).getClass().getSimpleName());
    }
}
