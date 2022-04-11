package com.aca.classroom.week7.colors;

public enum ColorType {
    RED("red color", 0xFFFF0000),
    GREEN("green color", 0xFF00FF00),
    BLUE("blue color", 0xFF0000F);
    private String colorStringRepresentation;
    private int value;

    ColorType(String colorStringRepresentation, int value) {
        this.colorStringRepresentation = colorStringRepresentation;
        this.value = value;
        System.out.println("default constructor was invoked " + colorStringRepresentation);
    }

    ColorType(String colorStringRepresentation) {
        this.colorStringRepresentation = colorStringRepresentation;
        this.value = 0;
        System.out.println("default constructor invoked " + colorStringRepresentation);
    }

    public String getColorStringRepresentation() {
        return colorStringRepresentation;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (this == ColorType.RED) {
            return "red color";
        } else if (this == ColorType.BLUE) {
            return "blue color";
        }
        return "green color";

    }
}