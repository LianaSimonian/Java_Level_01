package com.aca.classroom.week5;

public class Printers {
    public static void print(Object juniorDeveloper){
        System.out.println("___"+ juniorDeveloper.toString());
    }

    public static void main(String[] args) {
        print("jffdk");
        print(564);
        print(new Developer("fjfkdfk"));
        int i =465;
        //boxed
        Integer i1 = 456;

    }

}
