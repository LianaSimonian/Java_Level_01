package com.aca.classroom.week10.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Dell", 2000);
        System.out.println(map.get("Dell"));
    }
}
