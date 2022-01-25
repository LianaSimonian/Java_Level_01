package com.aca.homework.week2.cars;

public class Cars {

    //global case
    public static Car[] carsManufacturedAfter2010(Car[] cars) {
        //  Car[] tempCars = new Car[cars.length];
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
        //we are  getting  rid of Null
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
            //using default constructor
            /*
              cars[n]=new Car();
              cars[n].year=i;
              cars[n].brand="Porsche";
              n++;
             */
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