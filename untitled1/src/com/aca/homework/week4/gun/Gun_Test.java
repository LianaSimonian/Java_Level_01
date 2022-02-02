package com.aca.homework.week4.gun;

public class Gun_Test {
    public static void main(String[] args) {
        Gun gun = new Gun();
        System.out.println("gun is empty:" + gun.gunIsEmpty());

        for (int i = 0; i < 11; i++) {
            gun.loadSingleCartridge();
        }

        System.out.println("gun is full:" + gun.gunIsFull());

        System.out.println(gun.getNumberOfAvailableCartridges());
        gun.fire();
        gun.fire();
        gun.fire();
        System.out.println(gun.getNumberOfAvailableCartridges());
    }
}
