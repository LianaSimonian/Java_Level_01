package com.aca.homework.week7.ui;

public class UIButton extends UIView {
    private DiplomaColorType buttonColor;

    public UIButton(int width, int height, DiplomaColorType buttonColor) {
        super(width, height);
        this.buttonColor = buttonColor;
    }

    public void click() {
        System.out.println("clicked on a button having a color " + buttonColor
                + ", width: " + getWidth() + ", height: " + getHeight());
    }
}
