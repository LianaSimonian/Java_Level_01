package com.aca.homework.week5.light.out;

public class Light {
    private char state;

    public Light(boolean stateOfLight) {
        state = (stateOfLight == true) ? '+' : '0';
    }

    public void switchState() {
        state = (state == '+') ? '0' : '+';
    }

    public boolean isOn() {
        return state == '+';
    }

    public boolean isOff() {
        return state == '0';
    }

    @Override
    public String toString() {
        return state + "";
    }
}
