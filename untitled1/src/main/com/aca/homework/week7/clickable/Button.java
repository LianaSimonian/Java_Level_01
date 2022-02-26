package com.aca.homework.week7.clickable;

public class Button extends AbstractClickable {

    public Button(String name, Action action) {
        super(name, action);
    }

    public static Button ofButton(String name, Action action) {
        return new Button(name, action);
    }
}
