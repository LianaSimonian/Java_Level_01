package com.aca.homework.week4.developer;

public class JuniorDeveloper extends Developer {
    public long getLearningBudget() {
        return 2 * super.getLearningBudget();
    }

    public long getSalary() {
        return 300_000;
    }

    public void print() {
        System.out.println("name: " + getName() + ", " + "salary: " + getSalary() + ", " + "learning budget: " + getLearningBudget());
    }
}
