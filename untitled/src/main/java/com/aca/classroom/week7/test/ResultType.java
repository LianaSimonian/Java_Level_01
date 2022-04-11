package com.aca.classroom.week7.test;

public enum ResultType {
    FAIL("The execution is fail"),
    PASS("The execution is pass");
    private String massage;

    ResultType(String massage) {
        this.massage = massage;
    }

    public String getTestExecutionMassage(String testName) {
        return testName + " " + massage;
    }

}