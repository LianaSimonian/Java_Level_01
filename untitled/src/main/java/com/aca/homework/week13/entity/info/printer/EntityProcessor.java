package com.aca.homework.week13.entity.info.printer;

import java.lang.reflect.Field;
import java.util.function.Consumer;

public class EntityProcessor {

    private Consumer<String> consumer;

    public EntityProcessor(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    void printInfo(Object o) {
        if (o == null) throw new IllegalArgumentException("the argument of printInfo() function can not be null");

        StringBuilder info = new StringBuilder();
        if (o.getClass().isAnnotationPresent(Entity.class)) {
            info.append("table name is: ");
            info.append(getTableName(o));
            info.append(", id is ");
            info.append(getFiledValueAnnotatedAsId(o));
            info.append(", ");
            info.append(getColumnNamesAndFieldValues(o));
        }
        consumer.accept(info.toString());
    }

    private String getTableName(Object o) {
        Table tableAnnotation = o.getClass().getAnnotation(Table.class);
        if (tableAnnotation != null) {
            return tableAnnotation.name();
        } else {
            System.out.println(o.getClass() + "does not have @Table annotation");//cna throw exeption
            return "";
        }
    }

    private Long getFiledValueAnnotatedAsId(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation != null) {
                field.setAccessible(true);
                try {
                    return (Long) field.get(o);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("the Object " + o + " field " + field + " is private");
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("the Object " + o + " does not have such field " + field);
                }
            }
            field.setAccessible(false);
        }
        System.out.println(o.getClass() + "has not field annotated as @Id ");
        return -1L;
    }

    private String getColumnNamesAndFieldValues(Object o) {
        StringBuilder columns = new StringBuilder();
        for (Field field : o.getClass().getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                columns.append(columnAnnotation.name() + " is ");
                field.setAccessible(true);
                try {
                    columns.append(field.get(o));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("the Object " + o + " field " + field + " is private");
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("the Object " + o + " does not have such field " + field);
                }
                columns.append(", ");
            }
        }
        columns.delete(columns.length() - 2, columns.length());
        return columns.toString();
    }
}