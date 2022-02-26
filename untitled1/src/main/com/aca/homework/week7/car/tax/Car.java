package com.aca.homework.week7.car.tax;

public class Car {
    private int modelYear;
    private CarType type;
    public static int calendarYear = 2022;

    public Car(int modelYear, CarType type) {
        this.modelYear = modelYear;
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    public int getCarAge() {
        return calendarYear - modelYear;
    }

}
