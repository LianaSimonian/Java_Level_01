package com.aca.homework.week4.gun;

public class Gun {
    private int maxCountsOfCartridges;
    private int counter;

    public Gun() {
        maxCountsOfCartridges = 10;
        counter = 0;
    }

    public Gun(int maxCountsOfCartridges) {
        this.maxCountsOfCartridges = maxCountsOfCartridges;
        counter = 0;
    }

    public void loadSingleCartridge() {
        if (gunIsFull()) {
            System.out.println("Gun is full: We can not load the gun");
            return;
        }
        System.out.println("a cartridge is loaded");
        counter++;
    }

    public void fire() {
        if (gunIsEmpty()) {
            System.out.println("Gun is empty:We can not fire");
            return;
        }
        System.out.println("fire!");
        counter--;
    }

    public boolean gunIsEmpty() {
        return counter == 0;
    }

    public boolean gunIsFull() {
        return counter == maxCountsOfCartridges;
    }

    public int getMaxCountsOfCartridges() {
        return maxCountsOfCartridges;
    }

    public int getNumberOfAvailableCartridges() {
        return counter;

    }

}
