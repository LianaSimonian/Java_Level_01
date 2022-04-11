package com.aca.homework.week7.clickabletask;

public class AbstractClickable implements Clickable {
    private String name;
    private Action action;

    public AbstractClickable(String name, Action action) {
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