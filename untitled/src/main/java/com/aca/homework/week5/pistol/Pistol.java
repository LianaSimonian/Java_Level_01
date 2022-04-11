package com.aca.homework.week5.pistol;

public class Pistol {
    private String type;

    public Pistol(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'';
    }

    public void shoot() {
        System.out.println("fire");
    }
}
