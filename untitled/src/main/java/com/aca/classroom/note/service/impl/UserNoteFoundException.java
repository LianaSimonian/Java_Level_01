package com.aca.classroom.note.service.impl;

public class UserNoteFoundException extends RuntimeException {

    public UserNoteFoundException(String username) {
        super(String.format("User with the username %s not found", username));
    }

    public UserNoteFoundException(Long id) {
        super(String.format("User with the id %d not found", id));
    }
}