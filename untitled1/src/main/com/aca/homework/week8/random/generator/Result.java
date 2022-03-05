package com.aca.homework.week8.random.generator;

public class Result {
    private String resultText;
    private long executionDurationInMillis;

    public Result(String resultText, long executionDurationByMillis) {
        this.resultText = resultText;
        this.executionDurationInMillis = executionDurationByMillis;
    }

    public long getExecutionDurationByMillis() {
        return executionDurationInMillis;
    }

    public String getResultText() {
        return resultText;
    }

}