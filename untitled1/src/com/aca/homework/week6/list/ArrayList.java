package com.aca.homework.week6.list;

public class ArrayList implements List {
    private String[] elements = new String[10];
    private int numberOfElements = 0;

    public void add(String element) {
        if (numberOfElements < elements.length) {
            elements[numberOfElements++] = element;
        } else {
            String[] newArrayOfElements = new String[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newArrayOfElements[i] = elements[i];
            }
            newArrayOfElements[elements.length] = element;
            elements = newArrayOfElements;
            numberOfElements++;
        }
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= elements.length) {
            System.out.println("invalid index");
            throw new IndexOutOfBoundsException();
        }
        if (elements[index] == null)
            throw new RuntimeException();
        return elements[index];
    }

    public int getLength() {
        return elements.length;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
