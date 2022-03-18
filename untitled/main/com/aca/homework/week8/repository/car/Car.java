package com.aca.homework.week8.repository.car;

public class Car {
    private String vin;
    private int year;
    private int ownersCount;

    public Car(String vin, int year, int ownersCount) {
        this.vin = vin;
        this.year = year;
        this.ownersCount = ownersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != Car.class) return false;
        Car car = (Car) o;
        return year == car.year && ownersCount == car.ownersCount && vin.equals(car.vin);
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public String getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public void setOwnersCount(int ownersCount) {
        this.ownersCount = ownersCount;
    }

    public void setYear(int year) {
        this.year = year;
    }
}