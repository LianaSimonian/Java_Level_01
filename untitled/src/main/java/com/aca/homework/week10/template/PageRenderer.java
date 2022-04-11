package com.aca.homework.week10.template;

public class PageRenderer {
    private boolean topPageNumber;
    private boolean downPageNumber;

    protected PageRenderer(boolean topPageNumber, boolean downPageNumber) {
        this.topPageNumber = topPageNumber;
        this.downPageNumber = downPageNumber;
    }

    public PageRenderer() {
        this.topPageNumber = false;
        this.downPageNumber = false;
    }

    protected void printPage() {
        System.out.println("Page");
    }

    protected void printHeader() {
        System.out.println("Header");
    }

    protected void printFooter() {
        System.out.println("Footer");
    }

    public void print() {
        printHeader();
        if (topPageNumber)
            printPageNumber();
        printPage();
        if (downPageNumber)
            printPageNumber();
        printFooter();

    }

    protected void printPageNumber() {
        System.out.println("Page Number");
    }
}