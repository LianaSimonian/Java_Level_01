package com.aca.homework.week11.occurence;

import java.util.*;

public class KeyCalculator {
    private final Supplier<String> supplier;

    public KeyCalculator(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    public Map<String, Integer> askAndCalculate() {
        Map<String, Integer> map = new HashMap<>();
        String inputStringNumber = supplier.get();

        while (!inputStringNumber.equals("end")) {
            if (map.containsKey(inputStringNumber)) {
                map.replace(inputStringNumber, map.get(inputStringNumber) + 1);
            } else {
                map.put(inputStringNumber, 1);
            }
            inputStringNumber = supplier.get();
        }

        System.out.println(map);
        return map;
    }

    public static void main(String[] args) {
        new KeyCalculator(new StringOfNumberSupplier()).askAndCalculate();
    }
}