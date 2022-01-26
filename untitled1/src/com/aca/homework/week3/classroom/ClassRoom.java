package com.aca.homework.week3.classroom;

import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassRoom {
    public static void main(String[] args) {

        AcaClass acaClass = new AcaClass();
        acaClass.name = "java level 1";
        acaClass.fee = 500000;
        acaClass.students = getArrayOfStudent();

        acaClass.startMillis = convertStringToDateByMillis("2022/01/01 00:00:00");
        acaClass.endMillis = convertStringToDateByMillis("2022/05/01 00:00:00");
        acaClass.print();

    }

    public static Student[] getArrayOfStudent() {
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.println("Input  student name :");
            students[i].name = new Scanner(System.in).nextLine();
            System.out.println("Input  student surname :");
            students[i].surname = new Scanner(System.in).nextLine();
        }
        return students;
    }

    public static long convertStringToDateByMillis(String date) {
        String tempString = date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date tempdate = sdf.parse(tempString);
            long millis = tempdate.getTime();
            return millis;
        } catch (ParseException e) {
            return -1;
        }
    }
}
