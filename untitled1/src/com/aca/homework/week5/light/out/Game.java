package com.aca.homework.week5.light.out;

import java.util.Scanner;

public class Game {
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;
    private Light[][] lights;
    private int moves;

    public Game() {
        initialize();
    }

    private void initialize() {
        lights = new Light[HEIGHT][WIDTH];
        int[][] offStateCoordinates = {{0, 2}, {1, 1}, {1, 3}, {2, 0}, {2, 4}, {3, 1}, {3, 3}, {4, 2}};
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++)
                lights[i][j] = new Light(true);
        for (int[] offState : offStateCoordinates)
            lights[offState[0]][offState[1]].switchState();
    }

    private void start() {
        int[] coordinate = inputCoordinate();
        switchStates(coordinate[0], coordinate[1]);
    }

    private boolean isWin() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (lights[i][j].isOn()) {
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

    private int[] inputCoordinate() {
        while (true) {
            System.out.println("please enter a hit coordinates in '(x,y)' format :");
            String inputString = new Scanner(System.in).nextLine();
            int[] point = {Character.getNumericValue(inputString.charAt(1)), Character.getNumericValue(inputString.charAt(3))};
            if (!isValidCoordinate(point[0], point[1])) {
                System.out.println("Input error:please input true coordinate:");
                continue;
            } else return point;
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

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < HEIGHT && y >= 0 && y < WIDTH;
    }

    //if there was an inheritance, its may be to replace private functions with protected
    public void print() {
        System.out.println();
        System.out.println("moves: " + moves);
        System.out.println("  12345");
        System.out.println("---------");
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(lights[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}