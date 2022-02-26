package com.aca.homework.week7.clickable;

public class AbstractClickable implements Clickable {
    private Action action;
    private String name;

    public AbstractClickable(Action action, String name) {
        this.action = action;
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void click() {
        action.doAction(this);
    }

}
