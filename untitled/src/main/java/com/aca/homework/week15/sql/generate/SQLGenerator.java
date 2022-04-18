package com.aca.homework.week15.sql.generate;

import java.lang.reflect.Field;

public class SQLGenerator {

    public String generateInsert(User user) {
        if (user == null) throw new IllegalArgumentException("user argument can not be null");

        StringBuilder sqlInsertion = new StringBuilder();
        sqlInsertion.append("insert into ");
        sqlInsertion.append(getTableName(user));
        sqlInsertion.append(" (");
        sqlInsertion.append(getColumnNamesFromObject(user));
        sqlInsertion.append(")");
        sqlInsertion.append(" values (");
        sqlInsertion.append(getColumnValuesFromObject(user));
        sqlInsertion.append(");");

        return sqlInsertion.toString();
    }

    private String getTableName(User user) {
        Table tableAnnotation = user.getClass().getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        } else {
            System.out.println(user.getClass() + "does not have @Table annotation");
            return "";
        }
    }

    private String getColumnNamesFromObject(User user) {
        StringBuilder columnNames = new StringBuilder();

        for (Field field : user.getClass().getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                columnNames.append(column.name() + ", ");
            }
        }
        columnNames.delete(columnNames.length() - 2, columnNames.length());
        return columnNames.toString();
    }

    private String getColumnValuesFromObject(User user) {
        StringBuilder columnValues = new StringBuilder();

        for (Field field : user.getClass().getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                field.setAccessible(true);
                Object fieldValue;
                try {
                    fieldValue = field.get(user);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("the Object " + user + " field " + field + " is private");
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("the Object " + user + " does not have such field " + field);
                }
                if (fieldValue instanceof String) {
                    columnValues.append("'");
                    columnValues.append(fieldValue);
                    columnValues.append("'");
                } else {
                    columnValues.append(fieldValue);
                }
                columnValues.append(", ");
                field.setAccessible(false);
            }
        }

        columnValues.delete(columnValues.length() - 2, columnValues.length());
        return columnValues.toString();
    }
}