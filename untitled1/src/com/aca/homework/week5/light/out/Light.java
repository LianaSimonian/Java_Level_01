package com.aca.homework.week5.light.out;

public class Light {
    private char state;

    public Light(boolean stateOfLight) {
        state = (stateOfLight == true) ? '+' : '0';
    }

    public char getLight() {
        return state;
    }

    public void switchState() {
        state = (state == '+') ? '0' : '+';
    }
}
