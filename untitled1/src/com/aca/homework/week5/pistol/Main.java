package com.aca.homework.week5.pistol;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pistol[] pistols = create4Pistols();
        shootAll(pistols);
    }

    public static Pistol[] create4Pistols() {
        Pistol[] pistols = new Pistol[4];
        for (int i = 0; i < 4; i++) {
            String type = enterPistolType();
            if (type.equalsIgnoreCase("Air")) {
                pistols[i] = new AirPistol();
            }
            if (type.equalsIgnoreCase("Makarov")) {
                pistols[i] = new MakarovPistol();
            }
            if (type.equalsIgnoreCase("Nagant")) {
                pistols[i] = new NagantPistol();
            }
        }
        return pistols;
    }

    public static String enterPistolType() {
        System.out.println("please enter the type of pistol");
        return new Scanner(System.in).nextLine();
    }

    public static void shootAll(Pistol[] pistols) {
        for (int i = 0; i < pistols.length; i++) {
            pistols[i].shoot();
        }
    }
}
