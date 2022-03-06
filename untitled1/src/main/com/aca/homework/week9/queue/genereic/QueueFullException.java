package com.aca.homework.week9.queue.genereic;

public class QueueFullException extends RuntimeException {
    QueueFullException(String message) {
        super(message);
    }
}
