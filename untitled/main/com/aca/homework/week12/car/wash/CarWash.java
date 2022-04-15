package com.aca.homework.week12.car.wash;

import java.util.HashMap;
import java.util.Map;

public class CarWash {

    private final CarWashService service;
    private final CarRepository carRepository;
    private Map<String, Integer> carsWashedNumber;

    public CarWash(CarWashService service, CarRepository carRepository) {
        this.service = service;
        this.carRepository = carRepository;
        carsWashedNumber = carRepository.isEmpty() ? new HashMap<String, Integer>() : (Map<String, Integer>) carRepository.load();
    }

    public double wash(String plateNumber) {
        carsWashedNumber.put(plateNumber, carsWashedNumber.get(plateNumber) == null ? 1 : carsWashedNumber.get(plateNumber) + 1);
        int washNumber = carsWashedNumber.get(plateNumber);
        carRepository.save(new EntryImpl<String, Integer>(plateNumber, washNumber));

        if (washNumber % service.getFreeWashesNumber() == 0) {
            return 0;
        }
        return service.getPrice();
    }

    public String getName() {
        return service.getName();
    }

    public Map<String, Integer> getCarsWashedNumber() {
        return carsWashedNumber;
    }

    public static void main(String[] args) {
        final String PATH = "D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\com\\aca\\homework\\week12\\car\\wash\\";
        CarWash testSubject = new CarWash(new CarWashService("JILLY", 5, 15.5), new FileCarRepository(PATH + "JILLY" + ".txt"));
        testSubject.wash("12");
        testSubject.wash("12");
        testSubject.wash("12");
        testSubject.wash("125");
        testSubject.wash("12");
        testSubject.wash("126");
        testSubject.wash("126");
        testSubject.wash("126");
    }
}