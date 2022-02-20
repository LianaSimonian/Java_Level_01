package com.aca.homework.week4.snakee;

import java.util.Random;
import java.util.Scanner;
/*
I also could to have a separate array for the snake, but I tried to save memory, although otherwise we might get a more
 simple algorithm than this one.I tried to find more effective way
*/

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

    private char enterMovementDirection() {
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

        System.out.println("step: " + step);
        print();
        board[snakeHeadX][snakeHeadY] = step;
        step = incrementValueOfStringNumber(step);

        while (true) {
            char symbol = enterMovementDirection();
            if (symbol == up) {
                if (snakeMoveUp() == State.RETURN) return;
                else continue;
            }
            if (symbol == down) {
                if (snakeMoveDown() == State.RETURN) return;
                else continue;
            }
            if (symbol == left) {
                if (snakeMoveLeft() == State.RETURN) return;
                else continue;
            }
            if (symbol == right) {
                if (snakeMoveRight() == State.RETURN) return;
                else continue;
            }
        }
    }

    private void snakeMoveUpStep() {
        snakeHeadX--;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        step = incrementValueOfStringNumber(step);
        updateSnakeTail();
    }

    private void snakeMoveDownStep() {
        snakeHeadX++;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        step = incrementValueOfStringNumber(step);
        updateSnakeTail();

    }

    private void snakeMoveLeftStep() {
        snakeHeadY--;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        step = incrementValueOfStringNumber(step);
        updateSnakeTail();

    }

    private void snakeMoveRightStep() {
        snakeHeadY++;
        board[snakeHeadX][snakeHeadY] = step;
        System.out.println("step: " + step);
        step = incrementValueOfStringNumber(step);
        updateSnakeTail();

    }

    private State snakeMoveUp() {
        if (snakeHeadX - 1 < 0 || (isNumeric(board[snakeHeadX - 1][snakeHeadY]) && board[snakeHeadX - 1][snakeHeadY] != "0")) {//sxal
            System.out.println("you lose!!!");
            System.out.println("score: " + score);
            return State.RETURN;
        }
        if (board[snakeHeadX - 1][snakeHeadY].equals("0")) {
            snakeMoveUpStep();
            print();
            return State.CONTINUE;
        }
        if (board[snakeHeadX - 1][snakeHeadY].equals(appleSymbol)) {
            score++;
            extendSnake();
            if (!isGenerateRandomApple()) {
                System.out.println("you win!!!");
                System.out.println("score: " + score);
                return State.RETURN;
            }
            print();
            return State.CONTINUE;
        }
        return State.CONTINUE;
    }

    private State snakeMoveDown() {
        if (snakeHeadX + 1 >= 8 || (isNumeric(board[snakeHeadX + 1][snakeHeadY]) && board[snakeHeadX + 1][snakeHeadY] != "0")) {
            System.out.println("you lose!!!");
            System.out.println("score: " + score);
            return State.RETURN;
        }
        if (board[snakeHeadX + 1][snakeHeadY].equals("0")) {
            snakeMoveDownStep();
            print();
            return State.CONTINUE;
        }
        if (board[snakeHeadX + 1][snakeHeadY].equals(appleSymbol)) {
            score++;
            extendSnake();
            if (!isGenerateRandomApple()) {
                System.out.println("you win!!!");
                System.out.println("score: " + score);
                return State.RETURN;
            }
            print();
            return State.CONTINUE;
        }
        return State.CONTINUE;
    }

    private State snakeMoveLeft() {
        if (snakeHeadY - 1 < 0 || (isNumeric(board[snakeHeadX][snakeHeadY - 1]) && board[snakeHeadX][snakeHeadY - 1] != "0")) {
            System.out.println("you lose!!!");
            System.out.println("score: " + score);
            return State.RETURN;
        }
        if (board[snakeHeadX][snakeHeadY - 1].equals("0")) {
            snakeMoveLeftStep();
            print();
            return State.CONTINUE;
        }
        if (board[snakeHeadX][snakeHeadY - 1].equals(appleSymbol)) {
            score++;
            extendSnake();
            if (!isGenerateRandomApple()) {
                System.out.println("you win!!!");
                System.out.println("score: " + score);
                return State.RETURN;
            }
            print();
            return State.CONTINUE;
        }
        return State.CONTINUE;
    }

    private State snakeMoveRight() {
        if (snakeHeadY + 1 >= 8 || (isNumeric(board[snakeHeadX][snakeHeadY + 1]) && board[snakeHeadX][snakeHeadY + 1] != "0")) {
            System.out.println("you lose!!!");
            System.out.println("score: " + score);
            return State.RETURN;
        }
        if (board[snakeHeadX][snakeHeadY + 1].equals("0")) {
            snakeMoveRightStep();
            print();
            return State.CONTINUE;
        }
        if (board[snakeHeadX][snakeHeadY + 1].equals(appleSymbol)) {
            score++;
            extendSnake();
            if (!isGenerateRandomApple()) {
                System.out.println("you win!!!");
                System.out.println("score: " + score);
                return State.RETURN;
            }
            print();
            return State.CONTINUE;
        }
        return State.CONTINUE;
    }

    private void updateSnakeTail() {
        String valueOfOldSnakeTail = board[snakeTailX][snakeTailY];
        board[snakeTailX][snakeTailY] = "0";
        String valueOfNewSnakeTail = incrementValueOfStringNumber(valueOfOldSnakeTail);
        if (checkValidationX(snakeTailX - 1) && board[snakeTailX - 1][snakeTailY].equals(valueOfNewSnakeTail))
            snakeTailX = snakeTailX - 1;
        if (checkValidationX(snakeTailX + 1) && board[snakeTailX + 1][snakeTailY].equals(valueOfNewSnakeTail))
            snakeTailX = snakeTailX + 1;
        if (checkValidationY(snakeTailY + 1) && board[snakeTailX][snakeTailY + 1].equals(valueOfNewSnakeTail))
            snakeTailY = snakeTailY + 1;
        if (checkValidationY(snakeTailY - 1) && board[snakeTailX][snakeTailY - 1].equals(valueOfNewSnakeTail))
            snakeTailY = snakeTailY - 1;
    }

    private boolean isGenerateRandomApple() {
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

    private void extendSnake() {
        snakeHeadX = appleX;
        snakeHeadY = appleY;
        System.out.println("step: " + step);
        board[snakeHeadX][snakeHeadY] = step;
        step = incrementValueOfStringNumber(step);
    }

    private boolean isEmptyPositionForApple() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("0")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void print() {
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

    public static boolean checkValidationX(int x) {
        return x >= 0 && x < 8;
    }

    public static boolean checkValidationY(int y) {
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


