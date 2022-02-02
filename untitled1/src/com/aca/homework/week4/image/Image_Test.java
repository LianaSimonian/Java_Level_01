package com.aca.homework.week4.image;

public class Image_Test {
    public static void main(String[] args) {
        Image image = new Image(5, 10);

        int height =image.getHeight();
        int width = image.getWidth();
        image.draw(0, width/2);
        image.draw(1, width / 2);
        for (int i = 2; i < height - 2; i++) {
            image.draw(i, 1);
            image.draw(i, width - 2);
        }
        image.draw(height - 2, width / 2);
        image.draw(height - 1, width/ 2);

        image.show();
    }
}
