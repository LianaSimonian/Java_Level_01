package com.aca.homework.week4.snake;

import java.util.Random;
import java.util.Scanner;

public class Snake {
    private char[][] board;
    int snakeX;//head
    int snakeY;//head
    int snakeTailX;
    int snakeTailY;
    int appleX;
    int appleY;
    int score;

    public Snake() {
        initialize();
    }

    private void initialize() {
        board = new char[8][8];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '0';
            }
        appleX = 2;
        appleY = 1;
        board[snakeX][snakeY] = '*';
        board[appleX][appleY] = '=';
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
        while (!win()) {
            char symbol = enterMovementDirection();
            if (symbol == up) {
                if (snakeX - 1 < 0 || board[snakeX - 1][snakeY] == '*') {
                    System.out.println("you lose!!!");
                    return;
                }
                if (board[snakeX - 1][snakeY] == '0') {
                    // board[snakeX][snakeY]='0'; //snakeX = snakeX-1;// board[snakeX][snakeY]='*';
                    //snakemoveup,tailX,tailY,headX,headY
                    print();
                    continue;
                }
                if (board[snakeX - 1][snakeY] == '=') {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        return;
                    }
                    print();
                    continue;
                }
            }
            if (symbol == down) {
                if (snakeX + 1 < 0 || board[snakeX + 1][snakeY] == '*') {
                    System.out.println("you lose!!!");
                    return;
                }
                if (board[snakeX + 1][snakeY] == '0') {
                    // board[snakeX][snakeY]='0'; //snakeX = snakeX-1;// board[snakeX][snakeY]='*';
                    //snakemovedown,tailX,tailY,headX,headY
                    print();
                    continue;
                }
                if (board[snakeX + 1][snakeY] == '=') {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        return;
                    }
                    print();
                    continue;
                }
            }
            if (symbol == left) {
                if (snakeY - 1 < 0 || board[snakeX][snakeY - 1] == '*') {
                    System.out.println("you lose!!!");
                    return;
                }
                if (board[snakeX][snakeY - 1] == '0') {
                    // board[snakeX][snakeY]='0'; //snakeX = snakeX-1;// board[snakeX][snakeY]='*';
                    //snakemoveleft,tailX,tailY,headX,headY
                    print();
                    continue;
                }
                if (board[snakeX][snakeY - 1] == '=') {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        return;
                    }
                    print();
                    continue;
                }
            }
            if (symbol == right) {
                if (snakeY + 1 < 0 || board[snakeX][snakeY + 1] == '*') {
                    System.out.println("you lose!!!");
                    return;
                }
                if (board[snakeX][snakeY + 1] == '0') {
                    // board[snakeX][snakeY]='0'; //snakeX = snakeX-1;// board[snakeX][snakeY]='*';
                    //snakemoveright,tailX,tailY,headX,headY
                    print();
                    continue;
                }
                if (board[snakeX][snakeY + 1] == '=') {
                    score++;
                    extendSnake();
                    if (!isGenerateRandomApple()) {
                        System.out.println("you win!!!");
                        return;
                    }
                    print();
                    continue;
                }
            }
        }
        System.out.println("you Win!!!");
    }
    public void snakeUp(){
        board[snakeTailX][snakeTailY]='0';
        //snakeX--;
        snakeTailX--;
        //board[snakeX][snakeY]='*';
    }

    public boolean isGenerateRandomApple() {
        if (isEmptyPositionForApple()) {
            while (true) {
                appleX = new Random().nextInt(8);
                appleY = new Random().nextInt(8);
                if (board[appleX][appleY] == '0') {
                    board[appleX][appleY] = '=';
                    return true;
                }
            }
        }
        return false;
    }

    public void extendSnake() {
        snakeX = appleX;
        snakeY = appleY;
    }

    public boolean isEmptyPositionForApple() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '0') {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean win() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '0')
                    return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("score: " + score);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

