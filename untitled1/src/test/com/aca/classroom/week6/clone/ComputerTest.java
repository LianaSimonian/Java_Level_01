package com.aca.classroom.week6.clone;

class ComputerTest {
    public static void main(String[] args)throws CloneNotSupportedException {
       Computer computer = new Computer(Brand.DELL);
        Computer clone = computer.clone();
        System.out.println();

    }

}