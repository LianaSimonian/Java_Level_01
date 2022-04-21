package com.aca.homework.week15.repository.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements CrudRepository<Employee, String> {

    private final ConnectionFactory connectionFactory;

    public EmployeeRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void save(Employee t) {
        if (t == null) throw new IllegalArgumentException(" t Employee argument can not be null");

        Connection connection = connectionFactory.getObject();
        String sqlInsert = "insert into Employees (id, firstName, secondName, salary) values ('" + t.getId() + "', '" + t.getFirstName() +
                "', '" + t.getSecondName() + "', " + t.getSalary() + ");";
        try {
            connection.createStatement().execute(sqlInsert);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing sql:\n" + sqlInsert, e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error at closing connection with database having url " + ConnectionFactory.getDatabaseURL() + " password " + ConnectionFactory.getPassword() + " UserName " + ConnectionFactory.getUsername(), e);
        }
    }

    @Override
    public List<Employee> findAll() {
        Connection connection = connectionFactory.getObject();
        String sqlSelect = "select* from Employees;";
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(sqlSelect);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing sql:\n" + sqlSelect, e);
        }
        List<Employee> employeesList = new LinkedList<>();

        while (true) {
            boolean hasNext;
            try {
                hasNext = resultSet.next();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (hasNext == false) break;
            employeesList.add(getEmployeeFromCurrentRow(resultSet));
        }

        try {
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeesList;
    }

    @Override
    public Employee findById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id argument can not be null");
        }

        Connection connection = connectionFactory.getObject();
        String sqlSelect = "select * from Employees where id ='" + id + "'";
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(sqlSelect);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing sql:\n" + sqlSelect, e);
        }
        try {
            if (!resultSet.next()) return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Employee employee = getEmployeeFromCurrentRow(resultSet);
        try {
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }


    @Override
    public void deleteAll() {
        Connection connection = connectionFactory.getObject();
        String sqlDelete = "delete from Employees";
        try {
            connection.createStatement().execute(sqlDelete);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing sql:\n" + sqlDelete, e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error at closing connection with database having url " + ConnectionFactory.getDatabaseURL(), e);
        }
    }

    private Employee getEmployeeFromCurrentRow(ResultSet resultSet) {
        String id = null;
        String firstName = null;
        String secondName = null;
        Long salary = null;

        try {
            id = resultSet.getString(1);
            firstName = resultSet.getString(2);
            secondName = resultSet.getString(3);
            salary = resultSet.getLong(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Employee(id, firstName, secondName, salary);
    }
}