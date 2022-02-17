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
/*
Create Car class that has color, width, weight, and brand fields and getters only. All fields of the Car class should be initialized within a constructor.
Create Hyundai and Bmw subclasses.
Ask a user to input color, width, weight and brand name 5 times, create a car object based on the input fields and add them in an array. if the inputed brand name is other than 'bmw' or 'hyundai' just ignore it and do not create an object.
Implement toString methods in Car class.
Create a method that takes array of objects and for each object print the following
"1) brand: bmw, white: red, width: 5, wight 1200"
"2) brand: hyundai, color: red, width: 5, wight 1300"
..
"5) brand: bmw, color: black, width: 6, wight 1500"
 */
