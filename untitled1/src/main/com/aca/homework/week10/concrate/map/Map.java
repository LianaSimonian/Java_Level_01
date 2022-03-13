package com.aca.homework.week10.concrate.map;

import java.util.ArrayList;

public class Map {
    private ArrayList<Pair<String, String>> map = new ArrayList<>();
    private int numberOfElements;

    String put(@NotNull String key, @NotNull String value) {
        if (key == null)
            throw new NullPointerException("key is null");
        if (value == null)
            throw new NullPointerException("value is null");

        for (Pair<String, String> pair : map) {
            if (pair.getKey().equals(key)) {
                String keepOldValue = pair.getValue();
                pair.setValue(value);
                return keepOldValue;
            }
        }
        map.add(new Pair<String, String>(key, value));
        numberOfElements++;
        return null;
    }

    String getValue(@NotNull String key) {
        if (key == null)
            throw new NullPointerException("key is null");
        for (Pair<String, String> pair : map) {
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

    public static void main(String[] args) {
        ArrayList<Pair<String, String>> map = new ArrayList<>();
        map.add(new Pair<>("1", "2"));
        map.add(new Pair<>("2", "3"));
        map.add(new Pair<>("3", "3"));

        for (Pair<String, String> pair : map) {
            if (pair.getKey() == "1") {
                pair.setValue("4545");
            }
        }
        System.out.println(map);
    }
}