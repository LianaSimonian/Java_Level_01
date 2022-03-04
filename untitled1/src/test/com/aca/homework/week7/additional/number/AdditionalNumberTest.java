package com.aca.homework.week7.additional.number;

class AdditionalNumberTest {
    public static void main(String[] args) {
        int[] array1 = {4, 5, 7, 6, 3, 10};
        int[] array2 = {5, 7, 4, 6, 3};
        System.out.println(AdditionalNumber.findAdditionalNumberBySortMethod(array1, array2));
        System.out.println(AdditionalNumber.findAdditionalNumberBySumMethod(array1, array2));
        System.out.println(AdditionalNumber.findAdditionalNumberByXORMethod(array1, array2));
    }

}