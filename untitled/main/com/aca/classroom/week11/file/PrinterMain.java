package com.aca.classroom.week11.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrinterMain {
    public static void main(String[] args) throws FileNotFoundException {
        final String fileName = "C:\\Users\\user\\Desktop\\file.txt";
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println();
        printWriter.print('\n');
        printWriter.print(12);
        printWriter.print("fhghgg");
        printWriter.print(12f);
        printWriter.close();
    }
}