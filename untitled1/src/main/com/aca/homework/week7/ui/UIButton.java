package com.aca.homework.week7.ui;

public class UIButton extends UIView {
    private ColorType buttonColor;

    public UIButton(int width, int height, ColorType buttonColor) {
        super(width, height);
        this.buttonColor = buttonColor;
    }

    public void click() {
        System.out.println("clicked on a button having a color " + buttonColor
                + ", width: " + getWidth() + ", height: " + getHeight());
    }
}
