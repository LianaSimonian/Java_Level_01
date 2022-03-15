package com.aca.homework.week9.taskreverse;

import java.util.Stack;

public class StringUtils {
    static String reverseUsingStringBuilder(String string) {
        if (string == null)
            throw new IllegalArgumentException("the string is null");
        if (string.length() == 1) return string;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--)
            stringBuilder.append(string.charAt(i));
        return stringBuilder.toString();
    }

    public static String reverseUsingToCharArray(String string) {
        if (string == null)
            throw new IllegalArgumentException("string is null");
        int length = string.length();
        if (length == 1) return string;

        char[] charArray = string.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - 1 - i];
            charArray[length - 1 - i] = temp;
        }
        return String.valueOf(charArray);
    }

    public static String reverseUsingStack(String string) {
        if (string == null)
            throw new IllegalArgumentException("string is null");
        int length = string.length();
        if (length == 1) return string;

        char[] charArray = string.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < length; i++)
            stack.push(charArray[i]);
        int i = 0;
        while (!stack.isEmpty())
            charArray[i++] = stack.pop();

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        System.out.println(reverseUsingStringBuilder("hello"));
        System.out.println(reverseUsingToCharArray("hello"));
        System.out.println(reverseUsingStack("hello"));
    }
}
