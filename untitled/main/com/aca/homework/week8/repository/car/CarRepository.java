package com.aca.homework.week8.repository.car;

public class CarRepository {
    private final int size = 1000;
    private Car[] cars = new Car[size];
    private int totalCount;

    public Car save(Car car) {
        Car findCarByVin = findByVin(car.getVin());
        if (findCarByVin != null && !car.equals(findCarByVin)) {
            findCarByVin.setYear(car.getYear());
            findCarByVin.setOwnersCount(car.getOwnersCount());
            return findCarByVin;
        }
        if(car.equals(findCarByVin))
            return findCarByVin;
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
