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
/*
Create a Developer class that has a name field.

The Developer class should have getSalary method that returns a fixed 60_000 value.
Create name setter and getter methods.
The Developer class should also have getLearningBudget method that returns a fixed 300 value.


Create JuniorDeveloper subclass superclass of which is the Developer.
The learning budget should be x2 of one an ordinary developer has and the salary should be 300_000.



Create SeniorDeveloper subclass superclass of which is the Developer.
The learning budget should be x8 of one an ordinary developer has and the salary should be 3_000_000.


Do not use a constructor other than a default in the above-mentioned classes.

Create a print method to print the details of the class.

Create a developer named Gerard and print it (the print text should be "name: Gerard, salary: 60000, learning budget: 300")
Create a junior developer named Maricar and print it. (the print text should be "name: Maricar, salary: 300000, learning budget: 600")
Create a senior developer named Emily and print it. (the print text should be "name: Emily, salary: 3000000, learning budget: 2400")

note: The Developer class should have only one name field. The JuniorFeveloper and the SeniorDeveloper should not have any field.

 */