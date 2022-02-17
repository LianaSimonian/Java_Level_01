package com.aca.classroom.week6.figure.hierachy;

public class RectangleFigure implements Figure {
    private double width;
    private double height;

    public RectangleFigure(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (height + width);
    }
}
