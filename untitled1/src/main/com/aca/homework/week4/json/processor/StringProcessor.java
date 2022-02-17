package com.aca.homework.week4.json.processor;

import java.security.InvalidParameterException;

public class StringProcessor {
    private String json;

    StringProcessor(String json) {
        this.json = json;
    }

    String getValue(String key) {
        int i = json.indexOf(key);
        if (i == -1) {
            System.out.println("key not found");
            throw new InvalidParameterException();
        }
        int j = json.indexOf(':', i);
        int k = json.indexOf(',', j + 1);
        if (k == -1) {
            k = json.indexOf('}', j + 1);
        }
        return json.substring(j + 1, k);
    }
}
