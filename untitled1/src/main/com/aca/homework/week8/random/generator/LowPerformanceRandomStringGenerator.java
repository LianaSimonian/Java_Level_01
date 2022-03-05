package com.aca.homework.week8.random.generator;

public class LowPerformanceRandomStringGenerator implements RandomStringGenerator {

    @Override
    public Result randomString(int length) {
        if (RandomStringGenerator.isNotMultiplesOfThree(length)) return new Result("ERROR", 0);
        long startTime = System.currentTimeMillis();
        String resultText = "";
        for (int i = 0; i < length / 3; i++) {
            resultText += Randomizer.randomString();
        }
        return new Result(resultText, System.currentTimeMillis() - startTime);
    }
}
