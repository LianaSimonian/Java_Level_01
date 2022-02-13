package com.aca.homework.week5.equals;

public class Motorcycle {
    private Brand brand;
    private Owner owner;

    public Motorcycle(Brand brand, Owner owner) {
        this.brand = brand;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "brand=" + brand +
                ", owner: {" + owner.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        return this.brand == ((Motorcycle) o).brand && this.owner.equals(((Motorcycle) o).owner);
    }

    public void print() {
        System.out.println(toString());
    }

}
