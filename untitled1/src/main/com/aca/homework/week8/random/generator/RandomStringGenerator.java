package com.aca.homework.week8.random.generator;

public interface RandomStringGenerator {
    Result randomString(int length);

    public static boolean isNotMultiplesOfThree(int number) {
        return number % 3 != 0;
    }
}
