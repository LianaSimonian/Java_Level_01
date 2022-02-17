package com.aca.homework.week6.list;

public class ArrayList implements List {
    private String[] elements = new String[10];
    private int numberOfElements = 0;

    public void add(String element) {
        if (numberOfElements == elements.length) {
            addCapacity();
        }
        elements[numberOfElements++] = element;
    }

    public void addCapacity() {
        {
            String[] newArrayOfElements = new String[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newArrayOfElements[i] = elements[i];
            }
            elements = newArrayOfElements;
        }
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= elements.length) {
            System.out.println("invalid index");
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public int getLength() {
        return elements.length;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
