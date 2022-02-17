package com.aca.homework.week4.json.processor;

import java.util.Scanner;

public class StringProcessorTest {
    public static void main(String[] args) {
        String json = "{";

        for (int i = 0; i < 4; i++) {
            System.out.println("please input key");
            String key = new Scanner(System.in).nextLine();
            System.out.println("please input value");
            String value = new Scanner(System.in).nextLine();
            if(value=="")
                value = null;
            json += "\"" + key + "\"" + ":" + value + ",";
        }
        json = json.substring(0,json.length()-1) + "}";
        StringProcessor object = new StringProcessor(json);

        System.out.println(object.getValue("name"));
        System.out.println(object.getValue("surname"));
        System.out.println(object.getValue("age"));
        System.out.println(object.getValue("class"));

        System.out.println(json);

    }

}
