package com.aca.homework.week8.car.repository;

public class CarRepository {
    private final int size = 1000;
    private Car[] cars = new Car[size];
    private int totalCount;

    public Car save(Car car) {
        Car updatedCar = findByVin(car.getVin());
        if (updatedCar != null && car != updatedCar) {
            //update
            updatedCar.setYear(car.getYear());
            updatedCar.setOwnersCount(car.getOwnersCount());
            return updatedCar;
        }
        cars[totalCount++] = car;
        return cars[totalCount - 1];
    }

    public Car findByVin(String vin) {
        for (int i = 0; i < totalCount; i++) {
            if (cars[i].getVin().equals(vin))
                return cars[i];
        }
        return null;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
