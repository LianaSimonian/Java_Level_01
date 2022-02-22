package com.aca.homework.week7.clone;

public class Light implements Cloneable {
    private State state;

    private Light(State state) {
        this.state = state;
    }

    @Override
    protected Light clone() throws CloneNotSupportedException {
        return (Light) super.clone();
    }

    public static Light ofLight(State state) {
        return new Light(state);
    }

    @Override
    public String toString() {
        return "Light{" +
                "state=" + state +
                '}';
    }
}
