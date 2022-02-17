package com.aca.homework.week4.image;
/*
Create an Image class that contains pixels. The image pixel length in vertical and horizontal directions should be provided
in a constructor.The Image class must have a draw method that draws the * in the given location.
It also must have a show method that shows a drawn image.
e.g

Image image = new Image(5, 10);
image.show();

-----
-----
-----
-----
-----
-----
-----
-----
-----
-----

image.draw(1,2);
image.draw(2,1);
image.draw(2,2);
image.draw(2,3);
..
..
..
image.show();
-----
--*--
-***-
*****
*---*
*---*
*---*
*---*
*****
-----
 */

public class Image {
    private int width;
    private int height;
    private char[][] image;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        image = new char[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                image[i][j] = '-';
            }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(int i, int j) {
        if (i < 0 || i >= height) {
            System.out.println(i + " is out of range of image height ");
            return;
        }
        if (j < 0 || j >= width) {
            System.out.println(j + " is out of range of image width ");
            return;
        }
        if (image[i][j] == '*') {
            System.out.println("This place is busy. Please enter another position");
            return;
        }
        image[i][j] = '*';

    }

    public void show() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
}
