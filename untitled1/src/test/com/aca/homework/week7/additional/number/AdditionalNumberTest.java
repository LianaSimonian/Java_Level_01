package com.aca.homework.week7.additional.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdditionalNumberTest {
    @Test
    public void testForFindAdditionalNumberBySortMethod() {
        int[] array1 = {4, 5, 7, 6, 3, 10};
        int[] array2 = {5, 7, 4, 6, 3};
        int expectedValue = 10;
        Assertions.assertEquals(expectedValue, AdditionalNumber.findAdditionalNumberBySortMethod(array1, array2));
    }
    @Test
    public void testFindAdditionalNumberBySumMethod(){
        int[] array1 = {1, 5, 7, 6, 0, 4};
        int[] array2 = {5, 1, 4, 6, 7};
        int expectedValue = 0;
        Assertions.assertEquals(expectedValue, AdditionalNumber.findAdditionalNumberBySumMethod(array1, array2));
    }
    @Test
    public void findAdditionalNumberByXORMethod(){
        int[] array1 = {1, 5, 7, 6, 0, 4};
        int[] array2 = {5, 1, 4, 6, 7};
        int expectedValue = 0;
        Assertions.assertEquals(expectedValue, AdditionalNumber.findAdditionalNumberByXORMethod(array1, array2));
    }

}