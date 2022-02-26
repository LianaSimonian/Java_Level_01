package com.aca.homework.week7.clickable;

public abstract class AbstractClickable implements Clickable {
    private Action action;

    public AbstractClickable(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
