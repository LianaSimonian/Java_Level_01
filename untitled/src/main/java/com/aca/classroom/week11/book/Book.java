package com.aca.classroom.week11.book;

import java.util.*;

public class Book implements Comparable<Book> {
    private final String name;
    private final double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name='" + name + ", price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return name.equals(((Book) o).name) && price == ((Book) o).price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Book o) {
        int result = name.compareTo(o.name);
        if (result == 0) {
            return Double.valueOf(price).compareTo(o.price);//?(price - o.price) dont work
        } else {
            return result;
        }
    }

    public static void main(String[] args) {

        List.of();
        Set<Book> books = Set.of(new Book("effective", 54.99));
        //Hashmap equals() end hashcode()
        //HashSet equals() end hashcode()
        Set<Book> book1 = new TreeSet<>();//compareTo()
        book1.add(new Book("effective", 54.99));
        book1.add(new Book("effective", 54.99));
        book1.add(new Book("effective", 54.99));
        book1.add(new Book("effective", 54.99));
        book1.add(new Book("idiot", 10.99));
        System.out.println(book1.size());

        String s1 = "ab";
        String s2 = "ab";
        String s3 = "Ab";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));

        Set<Book> books1 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(final Book o1, final Book o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        for (Book book : books1) {
            System.out.println(book);
        }

        if (true)
            return;
/*
        String s1 = "name";
        String s2 = "name";
        System.out.println(s1 == s2);
        String s3 = "name";
        String s4 = args[0];
        System.out.println(Arrays.toString(args));
        System.out.println(s3 == s4);

*/
        Book book = new Book(args[0], Double.parseDouble(args[1]));
        System.out.println(books.contains(book));
        // Collections.singleton();
        //red-black- tree
        //shift shift enter search class
    }
    //you will check == only when have primitive type or enum
    //cntrl+alt+click + write
    //strategy design pattern| strategy
    //dependency injection effective java
}
