package com.aca.homework.week11.occurence;

import java.util.*;

public class KeyCalculator {
    private Supplier stringOfNumberSupplier;

    public KeyCalculator(Supplier stringOfNumberSupplier) {
        this.stringOfNumberSupplier = stringOfNumberSupplier;
    }

    public Map<String, Integer> askAndCalculate() {
        Map<String, Integer> map = new HashMap<>();
        String inputStringNumber = (String) stringOfNumberSupplier.get();

        while (!inputStringNumber.equals("end")) {
            if (map.containsKey(inputStringNumber))
                map.replace(inputStringNumber, map.get(inputStringNumber) + 1);
            else map.put(inputStringNumber, 1);
            inputStringNumber = (String) stringOfNumberSupplier.get();
        }

        System.out.println(map);
        return map;
    }

    public static void main(String[] args) {
        new KeyCalculator(new StringOfNumberSupplier()).askAndCalculate();
    }
}