package com.aca.classroom.week13;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockoingQueueMain {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        //final Integer take = arrayBlockingQueue.take();
        final Integer poll = arrayBlockingQueue.poll();

       // arrayBlockingQueue.put(10);
        arrayBlockingQueue.offer(10);
    }
}
