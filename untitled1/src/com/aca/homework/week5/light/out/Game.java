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

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < lights.length && y >= 0 && y < lights[0].length;
    }

    public void print() {
        System.out.println();
        System.out.println("moves: " + moves);
        System.out.println("  12345");
        System.out.println("---------");
        for (int i = 0; i < lights.length; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < lights[i].length; j++) {
                System.out.print(lights[i][j].getLight());
            }
            System.out.println();
        }
        System.out.println();
    }
    //if there was an inheritance, its may be to replace private functions with protected
}
/*
  12345
-------
1|++0++
2|+0+0+
3|0+++0
4|+0+0+
5|++0++


Create a Light class that can be either in 'on' or 'off' state.

Create a Game class that container matrix of lights of 5x5.
Create an initialzie() method that will fill the matrix with the light having the above depicted state where + means that the light is 'on' and 0 is 'off'.

To make the Game graphic more understandable fill the board with numbers, |s and -s.

The Game class should have start method that start asking light position in a format '(x,y)' and will switch the light state located at (x,y), (x-1,y), (x+1,y), (x,y-1) and (x,y+1) coordinates.

The game ends when all light are off.

for instance to win the game user should input the following strings

(3,3)
(1,1)
(5,5)
(5,1)
(1,5)

After each user input the moves count and the updated game graphic should be printed.

The game should be started in the folllowing way:
----------------------------------------------------------
The game started!!
moves: 0
  12345
-------
1|++0++
2|+0+0+
3|0+++0
4|+0+0+
5|++0++

please enter a hit coordinates in '(x,y)' format:
(3,3)

moves: 1
  12345
-------
1|++0++
2|+000+
3|00000
4|+000+
5|++0++

please enter a hit coordinates in '(x,y)' format:








.
.
.


You won!
 */