package com.aca.homework.week5.equals;

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Yorgantz", "Mark");
        Motorcycle motorcycle1 = new Motorcycle(Brand.YAMAHA, owner1);
        motorcycle1.print();

        Owner owner2 = new Owner("Tavares", "Mark");
        Motorcycle motorcycle2 = new Motorcycle(Brand.YAMAHA, owner2);
        motorcycle2.print();

        System.out.println(motorcycle1.equals(motorcycle2));
    }
}
