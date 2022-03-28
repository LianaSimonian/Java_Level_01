package com.aca.homework.week11.unique.cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.SortedSet;

class CalcutateTest {
    @Test
    public void testAskEndCalculate() {

        Calcutate testSubject = new Calcutate(new StringSupplierForTest(new String[]{"John,bmw,7", "Jack,opel,astra", "Mary,bmw,7", "Arsen,opel,xxx", "finish"}));
        SortedSet<Car> set = testSubject.askEndCalculate();

        Assertions.assertEquals(3, set.size());
        Iterator<Car> iterator = set.iterator();
        Assertions.assertEquals(new Car("bmw", "7"), iterator.next());
        Assertions.assertEquals(new Car("opel", "astra"), iterator.next());
        Assertions.assertEquals(new Car("opel", "xxx"), iterator.next());

    }
}