package com.aca.homework.week12.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;

public class ObjectJsonProcessor {

    public String process(Object o) {
        if (o == null) throw new IllegalArgumentException("the argument of process() function can not be null");

        StringBuilder json = new StringBuilder("{");
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            JsonProperty annotation = field.getAnnotation(JsonProperty.class);
            if (annotation != null) {
                json.append("\"" + annotation.value() + "\": \"");
                field.setAccessible(true);
                try {
                    json.append(field.get(o));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("the Object " + o + " field " + field + " is private");
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("the Object " + o + " does not have such field " + field);

                }
                json.append("\", ");
            }
        }
        for (Field field : fields) {
            field.setAccessible(false);
        }
        json.delete(json.length() - 2, json.length());
        json.append("}");
        return json.toString();
    }
}