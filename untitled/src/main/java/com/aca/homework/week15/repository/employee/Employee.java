package com.aca.homework.week15.repository.employee;

public class Employee {

    private final String id;
    private final String firstName;
    private final String secondName;
    private final Long salary;

    public Employee(String id, String firstName, String secondName, Long salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public Long getSalary() {
        return salary;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (secondName != null ? !secondName.equals(employee.secondName) : employee.secondName != null) return false;
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }

}