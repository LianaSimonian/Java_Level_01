package com.aca.classroom.week15.service;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("User with the username %s not found", username));
    }
}