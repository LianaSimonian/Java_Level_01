package com.aca.homework.week9.invoice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInvoiceReader implements InvoiceReader {
    //it wil be good file   pass  as parameter to read function()
    public Invoice[] read() throws FileNotFoundException {
        File file = new File("D:\\Users\\user\\IdeaProjects\\Java_Level_01\\untitled1\\src\\main\\com\\aca\\homework\\week9\\invoice\\service\\invoice.txt");
        int numberOfLinesInFile = findNumberOfLinesInFileUsingScanner(file);
        Invoice[] invoices = new Invoice[numberOfLinesInFile - 1];
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        for (int i = 0; i < numberOfLinesInFile - 1; i++) {
            String element = scanner.nextLine();
            invoices[i] = createInvoiceObjectFromString(element);
        }
        scanner.close();
        return invoices;
    }

    private static int findNumberOfLinesInFileUsingScanner(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lineNumber++;
        }
        return lineNumber;
    }

    private static Invoice createInvoiceObjectFromString(String string) {
        String[] strings = string.split(",");
        return new Invoice(strings[0], Integer.valueOf(strings[1]), InvoiceType.valueOf(strings[2]), strings[3]);
    }
}