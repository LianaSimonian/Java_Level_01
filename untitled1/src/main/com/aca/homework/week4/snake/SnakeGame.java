package com.aca.homework.week4.snake;

import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private String step = "1";
    private String[][] board;
    private int snakeHeadX;
    private int snakeHeadY;
    private int snakeTailX;
    private int snakeTailY;
    private String snakeSymbol = "*";
    private String appleSymbol = "=";
    private int appleX;
    private int appleY;
    private int score;

    public SnakeGame() {
        initialize();
    }

    private void initialize() {
        board = new String[8][8];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "0";
            }
        appleX = 2;
        appleY = 1;
        board[snakeTailX][snakeTailY] = snakeSymbol;
        board[appleX][appleY] = appleSymbol;
    }

    public char enterMovementDirection() {
        System.out.printf("please choose the direction: %s, %s, %s or %s", 'w', 's', 'a', 'd');
        while (true) {
            System.out.println();
            char symbol = new Scanner(System.in).nextLine().charAt(0);
            if (symbol == 'w' || symbol == 's' || symbol == 'a' || symbol == 'd')
                return symbol;
            else {
                System.out.printf("input error: please input symbols any of  %s, %s, %s or %s", 'w', 's', 'a', 'd');
            }
        }
    }

    public void play() {
        char up = 'w';
        char down = 's';
        char left = 'a';
        char right = 'd';
        print();
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step:" + step);
        step = incrementValueOfStringNumber(step);
        while (!isWin()) {
            char symbol = enterMovementDirection();
            if (symbol == up) {
                if (snakeHeadX - 1 < 0 || (isNumeric(board[snakeHeadX - 1][snakeHeadY]) && board[snakeHeadX - 1][snakeHeadY] != "0")) {//sxal
                    System.out.println("you lose!!!");
                    System.out.println("score: " + score);
                    return;
                }
                if (board[snakeHeadX - 1][snakeHeadY].equals("0")) {
                    snakeMoveUpStep();
                    print();
                    continue;
                }
                if (board[snakeHeadX - 1][snakeHeadY].equals(appleSymbol)) {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        System.out.println("score: " + score);
                        return;
                    }
                    print();
                    continue;
                }
            }
            if (symbol == down) {
                if (snakeHeadX + 1 >= 8 || (isNumeric(board[snakeHeadX + 1][snakeHeadY]) && board[snakeHeadX + 1][snakeHeadY] != "0")) {
                    System.out.println("you lose!!!");
                    System.out.println("score: " + score);
                    return;
                }
                if (board[snakeHeadX + 1][snakeHeadY].equals("0")) {
                    snakeMoveDownStep();
                    print();
                    continue;
                }
                if (board[snakeHeadX + 1][snakeHeadY].equals(appleSymbol)) {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        System.out.println("score: " + score);
                        return;
                    }
                    print();
                    continue;
                }
            }
            if (symbol == left) {
                if (snakeHeadY - 1 < 0 || (isNumeric(board[snakeHeadX][snakeHeadY - 1]) && board[snakeHeadX][snakeHeadY - 1] != "0")) {
                    System.out.println("you lose!!!");
                    System.out.println("score: " + score);

                    return;
                }
                if (board[snakeHeadX][snakeHeadY - 1].equals("0")) {
                    snakeMoveLeftStep();
                    print();
                    continue;
                }
                if (board[snakeHeadX][snakeHeadY - 1].equals(appleSymbol)) {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        System.out.println("score: " + score);
                        return;
                    }
                    print();
                    continue;
                }
            }
            if (symbol == right) {
                if (snakeHeadY + 1 >= 8 || (isNumeric(board[snakeHeadX][snakeHeadY + 1]) && board[snakeHeadX][snakeHeadY + 1] != "0")) {
                    System.out.println("you lose!!!");
                    System.out.println("score: " + score);
                    return;
                }
                if (board[snakeHeadX][snakeHeadY + 1].equals("0")) {
                    snakeMoveRightStep();
                    print();
                    continue;
                }
                if (board[snakeHeadX][snakeHeadY + 1].equals(appleSymbol)) {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        System.out.println("score: " + score);
                        return;
                    }
                    print();
                    continue;
                }
            }
        }
        System.out.println("you Win!!!");
        System.out.println("score: " + score);
    }

    public void snakeMoveUpStep() {
        snakeHeadX--;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        updateSnakeTail();
    }

    public void snakeMoveDownStep() {
        snakeHeadX++;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        updateSnakeTail();

    }

    public void snakeMoveLeftStep() {
        snakeHeadY--;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        updateSnakeTail();

    }

    public void snakeMoveRightStep() {
        snakeHeadY++;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        updateSnakeTail();

    }

    public void updateSnakeTail() {
        step = incrementValueOfStringNumber(step);
        String valueOfOldSnakeTail = board[snakeTailX][snakeTailY];
        board[snakeTailX][snakeTailY] = "0";
        String valueOfNewSnakeTail = incrementValueOfStringNumber(valueOfOldSnakeTail);
        //updateSnakeTailCoordinate
        if (checkValidationX(snakeTailX - 1) && board[snakeTailX - 1][snakeTailY].equals(valueOfNewSnakeTail))
            snakeTailX = snakeTailX - 1;
        if (checkValidationX(snakeTailX + 1) && board[snakeTailX + 1][snakeTailY].equals(valueOfNewSnakeTail))
            snakeTailX = snakeTailX + 1;
        if (checkValidationY(snakeTailY + 1) && board[snakeTailX][snakeTailY + 1].equals(valueOfNewSnakeTail))
            snakeTailY = snakeTailY + 1;
        if (checkValidationY(snakeTailY - 1) && board[snakeTailX][snakeTailY - 1].equals(valueOfNewSnakeTail))
            snakeTailY = snakeTailY - 1;
    }

    public boolean isGenerateRandomApple() {
        if (isEmptyPositionForApple()) {
            while (true) {
                appleX = new Random().nextInt(8);
                appleY = new Random().nextInt(8);
                if (board[appleX][appleY].equals("0")) {
                    board[appleX][appleY] = appleSymbol;
                    return true;
                }
            }
        }
        return false;
    }

    public void extendSnake() {
        snakeHeadX = appleX;
        snakeHeadY = appleY;
        System.out.println("step: " + step);
        board[snakeHeadX][snakeHeadY] = step;
        step = incrementValueOfStringNumber(step);
        //step=(char)(step+1);
    }

    public boolean isEmptyPositionForApple() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("0")) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isWin() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("0"))
                    return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("score: " + score);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isNumeric(board[i][j]) && board[i][j] != "0") {
                    System.out.print("* ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean checkValidationX(int x) {
        return x >= 0 && x < 8;
    }

    public boolean checkValidationY(int y) {
        return y >= 0 && y < 8;
    }

    public static String incrementValueOfStringNumber(String number) {
        return String.valueOf(Integer.valueOf(number) + 1);
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


