package com.aca.homework.week21.button.state;

public class ButtonOffState implements ButtonState {

    private static ButtonOffState instance = null;

    private ButtonOffState() {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public ColorType color() {
        return ColorType.BLUE;
    }

    @Override
    public ButtonState nextState() {
        return ButtonOnState.getInstance();
    }

    public static ButtonOffState getInstance() {
        if (instance == null) {
            instance = new ButtonOffState();
        }
        return instance;
    }
}