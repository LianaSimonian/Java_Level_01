package com.aca.homework.week8.repository.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {
    private CarRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CarRepository();
    }

    @Test
    public void testSave() {
        testSubject.save(Car.carOf("4Y1SL65848Z411439", 2010, 2));
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSaveSameCar2Times() {
        testSubject.save(Car.carOf("4Y1SL65848Z411439", 2010, 2));
        testSubject.save(Car.carOf("4Y1SL65848Z411439", 2010, 2));
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCars() {
        testSubject.save(Car.carOf("4Y1SL65848Z411400", 2010, 2));
        testSubject.save(Car.carOf("4Y1SL65848Z411439", 2010, 1));
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCarsTwice() {
        testSubject.save(Car.carOf("4Y1SL65848Z411400", 2010, 2));
        testSubject.save(Car.carOf("4Y1SL65848Z411439", 2010, 2));
        testSubject.save(Car.carOf("4Y1SL65848Z411400", 2010, 3));
        testSubject.save(Car.carOf("4Y1SL65848Z411439", 2010, 1));
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void testFindByVinWhenTotalCountIs0() {
        Assertions.assertEquals(null, testSubject.findByVin("4Y1SL65848Z411400"));
    }

    @Test
    public void testFindByVinWhenCarExists() {
        Car car = testSubject.save(Car.carOf("Y1SL65848Z411400", 2010, 2));
        Assertions.assertEquals(car, testSubject.findByVin(car.getVin()));
    }

    @Test
    public void testGetTotalCountWhenThereIsNoSavedCar() {
        Assertions.assertEquals(0, testSubject.getTotalCount());
    }
}