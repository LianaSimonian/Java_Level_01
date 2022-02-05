package com.aca.homework.week4.gun;

public class Gun {
    private int maxCountsOfCartridges;
    private int counter;

    public Gun() {
        maxCountsOfCartridges = 10;
    }

    public Gun(int maxCountsOfCartridges) {
        this.maxCountsOfCartridges = maxCountsOfCartridges;
    }

    public void loadSingleCartridge() {
        if (isGunFull()) {
            System.out.println("Gun is full: We can not load the gun");
            return;
        }
        System.out.println("a cartridge is loaded");
        counter++;
    }

    public void fire() {
        if (isGunEmpty()) {
            System.out.println("Gun is empty:We can not fire");
            return;
        }
        System.out.println("fire!");
        counter--;
    }

    public boolean isGunEmpty() {
        return counter == 0;
    }

    public boolean isGunFull() {
        return counter == maxCountsOfCartridges;
    }

    public int getMaxCountsOfCartridges() {
        return maxCountsOfCartridges;
    }

    public int getNumberOfAvailableCartridges() {
        return counter;

    }

}
