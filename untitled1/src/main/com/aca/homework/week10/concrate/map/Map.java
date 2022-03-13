package com.aca.homework.week10.concrate.map;

import java.util.List;
import java.util.ArrayList;

public class Map {
    private List<Pair<String, String>> pairList = new ArrayList<>();
    private int numberOfElements;

    void put(@NotNull String key, @NotNull String value) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        if (value == null)
            throw new IllegalArgumentException("value is null");

        for (Pair<String, String> pair : pairList) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
            }
        }
        pairList.add(new Pair<String, String>(key, value));
        numberOfElements++;
    }

    String getValue(@NotNull String key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
        for (Pair<String, String> pair : pairList) {
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    int size() {
        return numberOfElements;
    }

    boolean isEmpty() {
        return numberOfElements == 0;
    }

}