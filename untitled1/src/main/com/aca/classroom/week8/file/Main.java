package com.aca.classroom.week8.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\Users\\user\\IdeaProjects\\Java_Level_01\\untitled1\\src\\main\\com\\aca\\classroom\\week8\\file\\text.txt")
        );
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        scanner.close();
    }

}
