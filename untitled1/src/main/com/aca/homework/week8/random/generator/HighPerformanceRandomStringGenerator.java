package com.aca.homework.week8.random.generator;

public class HighPerformanceRandomStringGenerator implements RandomStringGenerator {

    @Override
    public Result randomString(int length) {
        if (RandomStringGenerator.isNotMultiplesOfThree(length)) return Result.resultOf("ERROR", 0);
        long startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length / 3; i++) {
            builder.append(Randomizer.randomString());
        }
        String resultText = builder.toString();
        return Result.resultOf(resultText, System.currentTimeMillis() - startTime);
    }
}

