package com.aca.homework.week5.exam;

public class ExamTest {
    private String username;
    private boolean passed;

    public ExamTest(String username, boolean passed) {
        this.username = username;
        this.passed = passed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPassed() {
        return passed;
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", passed=" + passed;
    }

    public void print() {
        System.out.println(toString());
    }

}
