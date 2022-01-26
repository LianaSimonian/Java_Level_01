package com.aca.homework.week2.random.string;

import java.util.Random;

public class RandomString {
    public static String randomStringWithLengthOf5() {
        char[] symbols = {'a', 'b', 'w', '7', '8', '9', 'u'};
        String str = " ";
        for (int i = 0; i < 5; i++) {
            int randomInt = new Random().nextInt(6);
            str += symbols[randomInt];
        }
        return str;
    }

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++)
            System.out.println(randomStringWithLengthOf5());

    }
}