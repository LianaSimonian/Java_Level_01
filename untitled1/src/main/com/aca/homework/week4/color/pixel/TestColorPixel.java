package com.aca.homework.week4.color.pixel;

public class TestColorPixel {
    public static void main(String[] args) {

        ColorPixel colorPixel = new ColorPixel("red");
        System.out.println("x coordinate is:" + colorPixel.getX() + " y coordinate is:" + colorPixel.getY() + " color is:" + colorPixel.getColor());
        ColorPixel colorPixel1 = new ColorPixel("blue", 1, 2);
        System.out.println("x coordinate is:" + colorPixel1.getX() + " y coordinate is:" + colorPixel1.getY() + " color is:" + colorPixel1.getColor());
        ColorPixel colorPixel2 = new ColorPixel("blue", 4, 5);
        System.out.println("x coordinate is:" + colorPixel2.getX() + " y coordinate is:" + colorPixel2.getY() + " color is:" + colorPixel2.getColor());

    }

}
