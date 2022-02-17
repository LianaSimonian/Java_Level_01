package com.aca.homework.week4.developer;

public class SeniorDeveloper extends Developer {
    public long getLearningBudget() {
        return 8 * super.getLearningBudget();
    }

    public long getSalary() {
        return 3_000_000;
    }

    public void print() {
        System.out.println("name: " + getName() + ", " + "salary: " + getSalary() + ", " + "learning budget: " + getLearningBudget());
    }
}
