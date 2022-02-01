package com.aca.homework.week2.projecttime;

import java.util.Scanner;

public class ProjectTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        printProjects(createThreeProjects(start));
    }

    public static Project[] createThreeProjects(long start) {
        Project[] projects = new Project[3];

        for (int i = 0; i < 3; i++) {
            projects[i] = createProject(start);
        }
        return projects;
    }

    public static void printProjects(Project[] projects) {
        for (int i = 0; i < projects.length; i++) {
            System.out.println(projects[i].creationSeconds + " " + projects[i].name);
        }
    }

    public static Project createProject(long start) {

        System.out.println("Please enter the project name:");
        String projectName = new Scanner(System.in).nextLine();

        return new Project(projectName, (System.currentTimeMillis() - start) / 1000);
    }
}
