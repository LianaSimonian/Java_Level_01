package com.aca.homework.week21.button.state;

import org.springframework.util.Assert;

public class Button {

    private ButtonState state;

    public Button(ButtonState state) {
        Assert.notNull(state, "the state param cannot be null");
        this.state = state;
    }

    public void switchState() {
        Assert.notNull(state, "the state cannot be null");
        state = state.nextState();
    }

    public boolean isEnabled() {
        return state.isEnabled();
    }

    public ColorType color() {
        return state.color();
    }

    public ButtonState getState() {
        return state;
    }
}