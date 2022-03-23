package com.aca.homework.week11.jackson.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class AddressTest {
    private Address testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Address("France", "Paris", "street1");
    }

    @Test
    public void testCountryFieldAnnotation() throws NoSuchFieldException {
        Field field = testSubject.getClass().getDeclaredField("country");
        Assertions.assertEquals(JsonProperty.class, field.getDeclaredAnnotations()[0].annotationType());
        Assertions.assertEquals("jsonFieldCountry", field.getAnnotation(JsonProperty.class).value());

    }

    @Test
    public void testCityFieldAnnotation() throws NoSuchFieldException {
        Field field = testSubject.getClass().getDeclaredField("city");
        Assertions.assertEquals(JsonProperty.class, field.getDeclaredAnnotations()[0].annotationType());
        Assertions.assertEquals("jsonFieldCity", field.getAnnotation(JsonProperty.class).value());

    }

    @Test
    public void testStreetFieldAnnotation()
            throws NoSuchFieldException {
        Field field = testSubject.getClass().getDeclaredField("street");
        Assertions.assertEquals(JsonProperty.class, field.getDeclaredAnnotations()[0].annotationType());
        Assertions.assertEquals("jsonFieldStreet", field.getAnnotation(JsonProperty.class).value());

    }
}