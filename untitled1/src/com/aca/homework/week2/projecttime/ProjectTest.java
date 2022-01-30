package com.aca.homework.week2.projecttime;

import java.util.Scanner;

public class ProjectTest {

    public static void main(String[] args) {

        printProjects(createTreeProjects());
    }

    public static Project[] createTreeProjects() {
        Project[] projects = new Project[3];

        for (int i = 0; i < 3; i++) {
            projects[i] = createProject();
        }
        return projects;
    }

    public static void printProjects(Project[] projects) {
        for (int i = 0; i < projects.length; i++) {
            System.out.println(projects[i].creationSeconds + " " + projects[i].name);
        }
    }

    public static Project createProject() {

        System.out.println("Please enter the project name:");
        String projectName = new Scanner(System.in).nextLine();

        return new Project(projectName, System.currentTimeMillis() / 1000);
    }
}
