package com.aca.homework;

public class TestingOfPerformance2code {
    //performance O(n)
    public int count(int[] array) {
        int countOfZeroes = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            do {
                if (currentNumber % 10 == 0) countOfZeroes++;
                currentNumber /= 10;
            } while (currentNumber != 0);
            // here I used do while instead of while because if the currentNumber is 0, the count of 0s would not increase,
            // and an extra condition would be needed.

            // also, I didn't move the part of counting 0s of a particular number to a method because using static methods
            // was prohibited.

        }
        return countOfZeroes;
    }

    //performance O(n^2)
    public int count1(int[] array) {
        String text = "";
        for (int i = 0; i < array.length; i++) {
            text = text + array[i];
        }
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }
}
