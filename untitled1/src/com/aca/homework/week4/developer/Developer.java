package com.aca.homework.week4.developer;

public class Developer {
    private String name;

    public long getSalary() {
        return 60_000;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getLearningBudget() {
        return 300;
    }

    public void print() {
        System.out.println("name: " + name + ", " + "salary: " + getSalary() + ", " + "learning budget: " + getLearningBudget());
    }
}
