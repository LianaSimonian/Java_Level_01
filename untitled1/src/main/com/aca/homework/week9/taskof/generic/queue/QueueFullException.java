package com.aca.homework.week9.taskof.generic.queue;

public class QueueFullException extends RuntimeException {
    QueueFullException(String message) {
        super(message);
    }
}
