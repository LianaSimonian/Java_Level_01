package com.aca.homework.week12.car.wash;

import java.util.HashMap;
import java.util.Map;

public class CarRepositoryForTest implements CarRepository {

    private Map<String, Integer> map = new HashMap<>();

    @Override
    public void save(Object data) {
        Entry<String, Integer> entry = (Entry<String, Integer>) data;
        map.put(entry.getKey(), entry.getValue());
    }

    @Override
    public Object load() {
        return map;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
}