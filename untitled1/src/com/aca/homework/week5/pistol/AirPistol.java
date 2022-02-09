package com.aca.homework.week5.pistol;

public class AirPistol extends Pistol {
    AirPistol() {
        super("Air");
    }

    public void shoot() {
        System.out.println(getType() + " pistol fire!");
    }
}
