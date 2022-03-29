package com.aca.homework.week11.map.performance;

import java.util.Random;

public class Randomizer {
    private final int LENGTH = 8;
    private final char[] symbols = {'a', 'b', 'c', 'd', 'e'};

    public String get8SizedString() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++)
            stringBuilder.append(symbols[random.nextInt(5)]);
        return stringBuilder.toString();
    }
}