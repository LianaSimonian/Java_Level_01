package com.aca.homework.week5.car;

public class Car {
    private String color;
    private long width;
    private long weight;
    private String brand;

    Car(String color, long width, long weight, String brand) {
        this.color = color;
        this.width = width;
        this.weight = weight;
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public long getWeight() {
        return weight;
    }

    public long getWidth() {
        return width;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "brand: " + brand + ", color: " + color + ", width: " + width + ", wight " + weight;
    }

    public void print() {
        System.out.println(toString());
    }
}

