package com.aca.homework.week11.unique.cars;

import java.util.SortedSet;
import java.util.TreeSet;

public class Calcutate {

    private final Supplier<String> supplier;

    public Calcutate(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    public SortedSet<Car> askEndCalculate() {
        SortedSet<Car> set = new TreeSet<>();
        System.out.println("please type your name,brand and model of your car");
        String inputString = supplier.get();
        while (!inputString.equals("finish")) {
            String[] strings = inputString.split(",");
            set.add(new Car(strings[1], strings[2]));
            inputString = supplier.get();
        }
        return set;
    }

    public void printResult(SortedSet<Car> set) {
        System.out.println("Number of unique brand and models: " + set.size());
        for (Car car : set)
            System.out.println(car);
    }
}