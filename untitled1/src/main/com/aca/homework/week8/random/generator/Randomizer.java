package com.aca.homework.week8.random.generator;

import java.util.Random;

public class Randomizer {
    public static String randomString() {
        char[] symbols = {'a', 'b', '7', '1', '9', '-'};
        String randomString = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int index =random.nextInt(symbols.length);
            randomString += symbols[index];
        }
        return randomString;
        //In the case of small N, it is no matter which one to use ( + or StringBuilder class ).I think efficiency is same.
    }
}
