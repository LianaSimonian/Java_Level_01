package com.aca.homework.week4.color.pixel;
/*
Create a Pixel that has x and y numeral coordinates and a default constructor.
Create a ColorPixel that extended from Pixel and has a color field.
Create setters and getters for properties in both classes.

Create 2 red pixels and 1 blue.
 */
public class Pixel {
    private int x;
    private int y;

    public Pixel() {
    }

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
