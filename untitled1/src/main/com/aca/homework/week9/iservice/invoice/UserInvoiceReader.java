package com.aca.homework.week9.iservice.invoice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInvoiceReader implements InvoiceReader {
    public Invoice[] read() {
        File file = new File("D:\\Users\\user\\IdeaProjects\\Java_Level_01\\untitled1\\src\\main\\com\\aca\\homework\\week9\\invoice\\service\\invoice.txt");
        int numberOfLinesInFile = findNumberOfLinesInFileUsingScanner(file);
        if (numberOfLinesInFile == -1) {
            System.out.println(file + " not found");
            return null;
        }
        Invoice[] invoices = new Invoice[numberOfLinesInFile - 1];
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();

            for (int i = 0; i < numberOfLinesInFile - 1; i++) {
                String element = scanner.nextLine();
                invoices[i] = createInvoiceObjectFromString(element);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return invoices;
    }

    private static int findNumberOfLinesInFileUsingScanner(File file) {
        int lineNumber = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return lineNumber;
    }

    private static Invoice createInvoiceObjectFromString(String string) {
        String[] strings = string.split(",");
        return new Invoice(strings[0], Integer.valueOf(strings[1]), InvoiceType.valueOf(strings[2]), strings[3]);
    }
}