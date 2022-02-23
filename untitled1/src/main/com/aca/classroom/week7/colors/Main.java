package com.aca.classroom.week7.colors;

public class Main {
    public static String getColor(ColorType color) {
        if (color == ColorType.GREEN) {
            return "green";
        } else if (color == ColorType.BLUE) {
            return "blue";
        }
        return "red";
    }

    public static void main(String[] args) {
        System.out.println(ColorType.GREEN);
        System.out.println(ColorType.RED.getColorStringRepresentation());
    }
}
