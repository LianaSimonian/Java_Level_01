package com.aca.classroom.week6.qa;

public abstract class TestExecution {
    private String description;

    public TestExecution(String description) {
        this.description = description;
    }

    public void start() {
        printTestDescription();
        Result result = execute();
        printResult(result);
    }

    public void printTestDescription() {
        System.out.println("String the test" + description);

    }

    public abstract Result execute();

    public void printResult(Result result) {
        System.out.println("The result of " + description + " is " + result);
    }
}
