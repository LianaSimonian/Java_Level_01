package com.aca.homework.week5.pistol;

public class MakarovPistol extends Pistol {
    MakarovPistol() {
        super("Makarov");
    }

    public void shoot() {
        System.out.println(getType() + " pistol fire!!!");
    }
}
