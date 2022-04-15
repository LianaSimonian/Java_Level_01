package com.aca.homework.week12.car.wash;

public class CarWashService {

    private final String name;
    private final int freeWashesNumber;
    private final double price;

    public CarWashService(String name, int freeWashesNumber, double price) {
        this.name = name;
        this.freeWashesNumber = freeWashesNumber;
        this.price = price;
    }

    public int getFreeWashesNumber() {
        return freeWashesNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}