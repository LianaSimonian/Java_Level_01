package com.aca.homework.week3.stack.strings;

public class Stack {
    private String[] elements;
    private int top;

    Stack() {
        elements = new String[10];
        top = -1;
    }

    public void push(String element) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("stack is full ");
        }
        elements[++top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return elements[top--];
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public String getTop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty,top element is missing");
        }
        return elements[top];
    }
    public int sizeOfStack(){
        return top + 1;
    }
}

