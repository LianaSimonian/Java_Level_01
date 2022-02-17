package com.aca.homework.week5.pistol;

public class NagantPistol extends Pistol {
    NagantPistol() {
        super("Nagant");
    }

    public void shoot() {
        System.out.println(getType() + " pistol fire!!!!!!");
    }
}
