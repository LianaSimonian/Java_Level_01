package com.aca.classroom.week6.qa;

public class Main {
    public static void main(String[] args) {
        // testExecution.start();
        TestExecution[] executions = {new MaxTestExecution(), new MinTestExecution()};
        startAll(executions);
        System.out.println();
        System.err.println("Error test");

    }

    public static void startAll(TestExecution[] executions) {
        for (TestExecution execution : executions) {
            execution.start();
        }
    }
}
