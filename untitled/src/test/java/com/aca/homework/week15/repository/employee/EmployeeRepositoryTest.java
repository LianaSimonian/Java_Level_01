package com.aca.homework.week15.repository.employee;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeRepositoryTest {

    private EmployeeRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new EmployeeRepository(new ConnectionFactory());
        testSubject.deleteAll();
    }

    @Test
    public void testSave() {
        testSubject.save(new Employee("id1", "firstName1", "secondName1", 1200L));
    }

    @Test
    public void testFindAll() {
        List<Employee> employeeList;
        Employee employee1 = new Employee("id1", "firstName1", "secondName1", 1200L);
        Employee employee2 = new Employee("id2", "firstName2", "secondName2", 1300L);
        testSubject.save(employee1);
        testSubject.save(employee2);

        employeeList = testSubject.findAll();
        Assertions.assertEquals(2, employeeList.size());
        Assertions.assertEquals(employee1, employeeList.get(0));
        Assertions.assertEquals(employee2, employeeList.get(1));
    }

    @Test
    public void testFindByIdWhenIdExist() {
        Employee employee1 = new Employee("id1", "firstName1", "secondName1", 1200L);
        testSubject.save(employee1);
        Employee employee = testSubject.findById("id1");
        Assertions.assertEquals(employee1, employee);
    }

    @Test
    public void testFindByIdWhenIdDoesNotExist() {
        Employee employee = testSubject.findById("id2");
        Assertions.assertNull(employee);
    }

    @Test
    public void testDeleteAll() {
        Employee employee1 = new Employee("id1", "firstName1", "secondName1", 1200L);
        Employee employee2 = new Employee("id2", "firstName2", "secondName2", 1300L);
        testSubject.save(employee1);
        testSubject.save(employee2);
        testSubject.deleteAll();
    }
}