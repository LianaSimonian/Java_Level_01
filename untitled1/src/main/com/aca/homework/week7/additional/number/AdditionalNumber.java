package com.aca.homework.week7.additional.number;

import java.util.Arrays;

public class AdditionalNumber {

    public static int findAdditionalNumberBySortMethod(int[] firstArray, int[] lastArray) {
        Arrays.sort(firstArray);
        Arrays.sort(lastArray);
        int lengthOfFirstArray = firstArray.length;
        for (int i = 0; i < lengthOfFirstArray - 1; i++) {
            if (firstArray[i] - lastArray[i] != 0) return firstArray[i];
        }
        return firstArray[lengthOfFirstArray - 1];
    }


    public static int findAdditionalNumberBySumMethod(int[] firstArray, int[] secondArray) {
        int sumOfElementsFirstArray = 0;
        int sumOfElementsSecondArray = 0;

        for (int element : firstArray)
            sumOfElementsFirstArray += element;

        for (int element : secondArray)
            sumOfElementsSecondArray += element;

        return sumOfElementsFirstArray - sumOfElementsSecondArray;

    }

    public static int findAdditionalNumberByXORMethod(int[] firstArray, int[] secondArray) {
        int result = 0;

        int[] combinedArray = combine2Arrays(firstArray, secondArray);
        for (int i = 0; i < combinedArray.length; i++)
            result = result ^ combinedArray[i];
        return result;
    }

    public static int[] combine2Arrays(int[] array1, int[] array2) {
        int firstArrayLength = array1.length;
        int lastArrayLength = array2.length;
        int lengthCombinedArray = firstArrayLength + lastArrayLength;
        int[] combinedArray = new int[lengthCombinedArray];

        for (int i = 0; i < firstArrayLength; i++)
            combinedArray[i] = array1[i];
        for (int j = firstArrayLength; j < lengthCombinedArray; j++)
            combinedArray[j] = array2[j - firstArrayLength];
        return combinedArray;
    }

}






