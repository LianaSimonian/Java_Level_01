package com.aca.exams.exam03.service.impl;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super(String.format("User with the username %s not found", username));
    }

    public UserNotFoundException(Long id) {
        super(String.format("User with the id %d not found", id));
    }
}