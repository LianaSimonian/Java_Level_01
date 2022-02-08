package com.aca.homework.week5.car;

import java.util.Scanner;

public class CarTester {
    public static void main(String[] args) {
        Car[] cars = create5CarsObject();
        printAll(cars);
    }

    public static Car[] create5CarsObject() {
        Car[] cars = new Car[5];
        for (int i = 0; i < 5; i++) {
            cars[i]=createCarObject();
        }
        return cars;
    }
    public static Car createCarObject(){
        System.out.println("input  color");
        String color = new Scanner(System.in).nextLine();
        System.out.println("input width");
        long width = new Scanner(System.in).nextLong();
        System.out.println("input weight");
        long weight = new Scanner(System.in).nextLong();
        System.out.println("input brand");
        String brand = new Scanner(System.in).nextLine();
        if (brand.equalsIgnoreCase("bmw")) {
           return new Bmw(color, width, weight);
        }
        if (brand.equalsIgnoreCase("hyundai")) {
            return new Hyundai(color, width, weight);
        }
        return null;
    }
    public static void printAll(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                System.out.println("input error:" + (i + 1) + "th elem is not bmw or Hyundai");
                continue;
            }
            System.out.print(i + 1 + ") ");
            cars[i].print();
        }
    }
}
