package com.aca.homework.week7.clickable;

public class Image extends AbstractClickable {

    public Image(String name, Action action) {
        super(action, name);
    }

    public static Image ofImage(String name, Action action) {
        return new Image(name, action);
    }
}
