package com.aca.homework.week21.button.state;

public class ButtonOnState implements ButtonState {

    private static ButtonOnState instance = null;

    private ButtonOnState() {

    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public ColorType color() {
        return ColorType.GREEN;
    }

    @Override
    public ButtonState nextState() {
        return ButtonOffState.getInstance();
    }

    public static ButtonOnState getInstance() {
        if (instance == null) {
            instance = new ButtonOnState();
        }
        return instance;
    }
}