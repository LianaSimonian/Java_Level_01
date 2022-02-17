package com.aca.homework.week3.license.covid.test.license.covid.test;

public class DrivingLicense {
    private User user;
    private char[] drivingLicense;

    public DrivingLicense(User user, char[] drivingLicense) {
        if (checkingValidRange(drivingLicense)) {
            this.user = user;
            this.drivingLicense= drivingLicense;
        } else throw new IllegalArgumentException("drivingLicense range is invalid");

    }

    public static boolean checkingValidRange(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!(array[i] >= 'A' && array[i] <= 'E')) {
                return false;
            }
        }
        return true;
    }
    public User getUser(){
        return user;
    }
    public void setUser(){
        this.user= user;
    }
    public char[] getDrivingLicense(){
        return  drivingLicense;
    }
    public void setDrivingLicense(char[] drivingLicense){
        this.drivingLicense = drivingLicense;
    }
}

