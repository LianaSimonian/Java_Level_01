package com.aca.homework.week2.cheesboard;

import java.util.Scanner;

public class PossibleMovesOfHorse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input horse  starting point in string format :cell1");
        String cell1 = sc.nextLine();
        System.out.println("input position where  the  player wants to move the horse:cell2 ");
        String cell2 = sc.nextLine();
        System.out.println("checking is valid step from cell1 to cell2 or not");
        int x1 = cell1.charAt(0) - 'a', y1 = cell1.charAt(1) - '1';
        int x2 = cell2.charAt(0) - 'a', y2 = cell2.charAt(1) - '1';
        int[] X = {-2, -2, 2, 2, 1, -1, -1, 1};
        int[] Y = {-1, 1, 1, -1, 2, 2, -2, -2};
        for(int i=0;i<8;i++){

            int a=x1+ X[i];
            int b =y1+Y[i];
            if(a>=0 && a<8 && b>=0 && b<8 && x2 ==a && y2 == b){
                System.out.println("move is possible");
                return;
            }
        }
        System.out.println("move is impossible");

    }
}