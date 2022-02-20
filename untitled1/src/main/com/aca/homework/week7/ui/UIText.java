package com.aca.homework.week7.ui;

public class UIText extends UIView {
    private String textValue;
    private ColorType textColor;

    public UIText(int width, int height, String textValue, ColorType textColor) {
        super(width, height);
        this.textValue = textValue;
        this.textColor = textColor;
    }

    public void click() {
        System.out.println("clicked on a text " + textValue + ", having a color " + textColor
                + ", width: " + getWidth() + ", height: " + getHeight());
    }
}
