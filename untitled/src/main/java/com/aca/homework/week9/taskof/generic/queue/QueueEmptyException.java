package com.aca.homework.week9.taskof.generic.queue;

public class QueueEmptyException extends RuntimeException {
    QueueEmptyException(String message) {
        super(message);
    }
}
