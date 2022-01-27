package com.aca.classroom.week3.money;

public class Money {
    public static double money(){
        double sum =150000 ;

        for(int i =1;i<=365;i++){
            sum+=(sum /100);

        }
        return sum;
    }
    public static void main(String[] args) {

        System.out.println(money());
    }
}