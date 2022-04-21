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
    }

    @Test
    public void testSave() {
        testSubject.save(new Employee("id1", "firstName1", "secondName1", 1200L));
    }

    @Test
    public void testFindAll() {
        List<Employee> employeeList;
        employeeList = testSubject.findAll();
        Assertions.assertEquals(1, employeeList.size());
        Assertions.assertEquals(new Employee("id1", "firstName1", "secondName1", 1200L), employeeList.get(0));
    }

    @Test
    public void testFindByIdWhenIdExist() {
        Employee employee = testSubject.findById("id1");
        Assertions.assertEquals(new Employee("id1", "firstName1", "secondName1", 1200L), employee);
    }

    @Test
    public void testFindByIdWhenIdDoesNotExist() {
        Employee employee = testSubject.findById("id2");
        Assertions.assertNull(employee);
    }

    @Test
    public void testDeleteAll() {
        testSubject.deleteAll();
    }
}