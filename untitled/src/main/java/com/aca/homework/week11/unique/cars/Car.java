package com.aca.homework.week11.unique.cars;


public class Car implements Comparable<Car> {
    private final String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public int compareTo(Car o) {
        int result = brand.compareTo(o.brand);
        if (result == 0) {
            result = model.compareTo(o.model);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return brand.equals(((Car) o).brand) && model.equals(((Car) o).model);
    }

    @Override
    public String toString() {
        return "brand:  " + brand + ", model:  " + model;
    }

}