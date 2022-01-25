package com.aca.homework.week2.projecttime;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Scanner;

public class ProjectTest {

    public static void printProjects(Project[] projects) {
        for (int i = 0; i < projects.length; i++) {
            System.out.println(projects[i].creationSeconds + " " + projects[i].name);
        }
    }

    public static Project createProject() {

        System.out.println("Please enter the project name:");
        String projectName = new Scanner(System.in).nextLine();

        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        long upTime = runtimeBean.getUptime();

        /*
         //using default constructor
        Project temp = new Project();
        temp.name=str;
        temp.creationSeconds=upTime;
        return temp;
         */

        return new Project(projectName, upTime);
    }

    public static void main(String[] args) {
        Project[] projects = new Project[3];

        for (int i = 0; i < 3; i++) {
            projects[i] = createProject();
        }

        printProjects(projects);
    }

}
