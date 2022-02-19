package com.aca.homework.week4.color.pixel;

public class ColorPixel extends Pixel {
    private String color;

    public ColorPixel() {
        super();
    }

    public ColorPixel(String color) {
        super();
        this.color = color;
    }

    public ColorPixel(String color, int x, int y) {
        super(x, y);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
