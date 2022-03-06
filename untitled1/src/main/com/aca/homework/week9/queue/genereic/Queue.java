package com.aca.homework.week9.queue.genereic;

public class Queue<T> {
    private final int size = 10_000;
    private Object[] queue = new Object[size];
    private int front;
    private int back;
    private int count;

    public void produce(T object) {
        if (object == null) throw new IllegalArgumentException("passed argument is null");
        if (isFull()) {
            throw new QueueFullException("queue is full");
        }
        queue[back] = object;
        back = (back + 1) % size;
        count++;
    }

    public T consume() {
        if (isEmpty()) {
            throw new QueueEmptyException("queue is empty");
        }
        Object lastAdded = queue[front];
        queue[front] = null;
        front = (front + 1) % size;
        count--;
        return (T) lastAdded;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count > size;
    }
}
