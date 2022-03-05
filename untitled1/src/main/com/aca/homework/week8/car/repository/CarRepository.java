package com.aca.homework.week8.car.repository;

public class CarRepository {
    private final int size = 1000;
    private Car[] cars = new Car[size];
    private int totalCount;

    public Car save(Car car) {
        Car addedCar = findByVin(car.getVin());
        if (addedCar != null && car != addedCar) {
            //update
            addedCar.setYear(car.getYear());
            addedCar.setOwnersCount(car.getOwnersCount());
            return addedCar;
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
