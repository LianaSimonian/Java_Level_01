package com.aca.homework.week1.facecontrol;

import java.util.Scanner;
import java.util.InputMismatchException;

public class FaceControl {
    public static boolean isAnameSamePname(String aname, String pname) {
        return aname.equalsIgnoreCase(pname);
    }

    public static boolean isUageSamePage(int uage, int page) {

        return uage == page;
    }

    public static boolean isUageGreaterThan18(int uage) {

        return uage > 18;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1;
        String str2;
        int i1;
        int i2;
        System.out.println("input answered Name  :");
        str1 = in.nextLine();
        System.out.println("input Passport Name :");
        str2 = in.nextLine();

        try {
            System.out.println("input Asked Age :");
            i1 = in.nextInt();
            System.out.println("input Passport Age :");
            i2 = in.nextInt();


            System.out.println("Are passport name same with answer name, age same with passport age and, age greater than 18 ?");
            if (isAnameSamePname(str1, str2) && isUageSamePage(i1, i2) && isUageGreaterThan18(i1)) {
                System.out.println("yes");
            } else {
                System.out.println("No");
            }
        } catch (InputMismatchException e) {
            System.out.println("input error:needed integer:" + e);
        }
    }
}
