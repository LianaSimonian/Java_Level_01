package com.aca.homework.week5.light.out;

import java.util.Scanner;

public class Game {
    private Light[][] lights;
    private int moves;

    public Game() {
        initialize();
    }

    private void initialize() {
        lights = new Light[5][5];
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                if (isAcceptCertainValues(i, j)) {
                    lights[i][j] = new Light(false);
                } else
                    lights[i][j] = new Light(true);
            }
        }
    }

    private void start() {
        String coordinate = inputCoordinate();
        switchStates(Character.getNumericValue(coordinate.charAt(1)), Character.getNumericValue(coordinate.charAt(3)));
    }

    private boolean isWin() {
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                if (lights[i][j].getLight() == '+') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchStates(int i, int j) {
        lights[i][j].switchState();
        if (isValidCoordinate(i + 1, j)) lights[i + 1][j].switchState();
        if (isValidCoordinate(i - 1, j)) lights[i - 1][j].switchState();
        if (isValidCoordinate(i, j + 1)) lights[i][j + 1].switchState();
        if (isValidCoordinate(i, j - 1)) lights[i][j - 1].switchState();
    }

    private String inputCoordinate() {
        while (true) {
            System.out.println("please enter a hit coordinates in '(x,y)' format :");

            String inputString = new Scanner(System.in).nextLine();
            if (!isValidCoordinate(Character.getNumericValue(inputString.charAt(1)), Character.getNumericValue(inputString.charAt(3)))) {
                System.out.println("Input error:please input true coordinate:");
                continue;
            } else return inputString;
        }
    }

    public void play() {
        System.out.println("_________________________________________");
        System.out.println("the game started!!!");
        print();
        while (!isWin()) {
            start();
            moves++;
            print();
        }
        System.out.println("you Win!!!");
    }

    private boolean isAcceptCertainValues(int i, int j) {
        return (i == 0 && j == 2) || (i == 1 && j == 1) || (i == 1 && j == 3) || (i == 2 && j == 0)
                || (i == 2 && j == 4) || (i == 3 && j == 1) || (i == 3 && j == 3) || (i == 4 && j == 2);
    }

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < lights.length && y >= 0 && y < lights[0].length;
    }

    public void print() {
        System.out.println();
        System.out.println("moves: " + moves);
        System.out.println("  12345");
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < 5; j++) {
                System.out.print(lights[i][j].getLight());
            }
            System.out.println();
        }
        System.out.println();
    }
}
