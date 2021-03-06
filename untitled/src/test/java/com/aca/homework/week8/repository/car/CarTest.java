package com.aca.homework.week8.repository.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void testWhenReferenceIsSame() {
        Car car = new Car("4Y1SL65848Z411439", 2005, 2);
        Assertions.assertTrue(car.equals(car));
    }

    @Test
    public void testWhenCarsHaveSameFieldValues() {
        Car car1 = new Car("4Y1SL65848Z411439", 2005, 2);
        Car car2 = new Car("4Y1SL65848Z411439", 2005, 2);
        Assertions.assertTrue(car1.equals(car2));
    }

    @Test
    public void testCarEqualString() {
        Car car = new Car("4Y1SL65848Z411439", 2005, 2);
        Assertions.assertFalse(car.equals("String"));
    }
}