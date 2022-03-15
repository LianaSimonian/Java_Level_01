package com.aca.classroom.week7.colors.clone;

public class PredatorAnimal extends Animal {
    public PredatorAnimal(String name) {
        super(AnimalType.PREDATOR, name);
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Animal tiger = new PredatorAnimal("tiger");
        Animal clonedPredator = tiger.clone();
        System.out.println(tiger.clone().getClass());
        Animal tiger1 = new Animal(AnimalType.MAMMAL, "tiger");
        Animal clonedAnimal = tiger.clone();
        System.out.println(tiger1.clone().getClass());
    }
}
