package com.aca.classroom.week6.figure.factory;

public class Figure {
    private int width;
    private int height;
    private FigureType type;
    private int radius;

    public FigureType getType() {
        return type;
    }

    public Figure(int width, int height) {
        this.width = width;
        this.height = height;
        this.type = FigureType.RECTANGLE;

    }

    public Figure(int radius) {
        this.radius = radius;
        this.type = FigureType.CIRCLE;
    }

    public double area() {
        if (type == FigureType.RECTANGLE)
            return width * height;
        else return Math.PI * radius * radius;
    }

    public String toString() {
        if (this.type == FigureType.RECTANGLE)
            return "RECTANGLE:width=" + width + "height=" + height;
        else return "CIRCLE:radius=" + radius;
    }


    public double perimeter() {
        if (type == FigureType.CIRCLE)
            return 2 * Math.PI * radius;
        else return 2 * (height + width);
    }

    public static void main(String[] args) {
        new Figure(10, 10);
        new Figure((10));

        Figure.ofCircle(12);
        Figure.ofRectangle(10, 21);
    }

    //static  factory
    public static Figure ofRectangle(int width, int height) {
        return new Figure(width, height);
    }

    public static Figure ofCircle(int radius) {
        return new Figure(radius);
    }
}
