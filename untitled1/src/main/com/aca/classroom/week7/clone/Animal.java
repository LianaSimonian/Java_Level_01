package com.aca.classroom.week7.clone;

import java.util.concurrent.Callable;

public class Animal implements Cloneable {
    private AnimalType type;
    private String name;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    protected Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
        //return new Animal(this.type,this.name); //polimorphysm not work
    }


}
