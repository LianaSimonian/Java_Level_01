package com.aca.homework.week2.cars;

public class Cars {

    public static Car[] carsManufacturedAfter2010(Car[] cars) {

        int length1 = 0 ;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].year >= 2010 && cars[i].year <= 2020) {
                length1++;
            }
        }
        Car[] tempCars = new Car[length1];
        int n = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].year >= 2010 && cars[i].year <= 2020) {
                tempCars[n++] = new Car(cars[i].year, cars[i].brand);
            }

        }
        return tempCars;
    }

    public static Car[] carsManufacturedAfter2010Version2(Car[] cars) {
        Car[] tempCars = new Car[cars.length];
        int n = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].year >= 2010 && cars[i].year <= 2020) {
                tempCars[n++] = new Car(cars[i].year, cars[i].brand);
            }
        }
        if (n == cars.length) {
            return tempCars;
        }

        Car[] tempCars1 = new Car[n];
        for (int i = 0; i < n; i++) {
            tempCars1[i] = tempCars[i];

        }
        return tempCars1;
    }


    public static void main(String[] args) {
        Car[] cars = new Car[41];

        int n = 0;
        for (int i = 1980; i <= 2020; i++) {

            cars[n++] = new Car(i, "Porsche");
        }
        Car[] cars1 = carsManufacturedAfter2010(cars);
        for (int i = 0; i < cars1.length; i++) {
            System.out.println(cars1[i].brand + " " + cars1[i].year);

        }
        
        System.out.println();
        cars1 = carsManufacturedAfter2010Version2(cars);
        for (int i = 0; i < cars1.length; i++) {
            System.out.println(cars1[i].brand + " " + cars1[i].year);

        }

    }
}
