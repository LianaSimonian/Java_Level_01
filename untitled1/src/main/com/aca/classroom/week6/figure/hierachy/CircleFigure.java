package com.aca.classroom.week6.figure.hierachy;

public class CircleFigure implements Figure {
    int radius;

    public CircleFigure(int radius) {

        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
//item23