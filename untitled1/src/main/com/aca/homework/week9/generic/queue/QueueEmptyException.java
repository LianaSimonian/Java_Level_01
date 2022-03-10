package com.aca.homework.week9.generic.queue;


public class QueueEmptyException extends RuntimeException {
    QueueEmptyException(String message) {
        super(message);
    }
}
