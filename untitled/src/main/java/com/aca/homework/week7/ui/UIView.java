package com.aca.homework.week7.ui;

public abstract class UIView {
    private double width;
    private double height;

    public UIView(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public abstract void click();
}
