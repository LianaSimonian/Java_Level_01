package com.aca.homework.week7.clone;

class LightTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Light light1 = Light.ofLight(State.OFF);
        System.out.println(light1);
        Light cloneLight1 = light1.clone();
        System.out.println(cloneLight1);

        Light light2 = Light.ofLight(State.ON);
        System.out.println(light2);
        Light cloneLight2 = light2.clone();
        System.out.println(cloneLight2);

    }
}