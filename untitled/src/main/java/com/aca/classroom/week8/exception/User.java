package com.aca.classroom.week8.exception;

public class User {
    private String userName;
    private String firstName;

    public User(String userName, String firstName) {

        if (firstName == null) throw new RuntimeException("the firstName is null");
        if (userName == null) throw new RuntimeException("the lastName is null");
        this.userName = userName;
        this.firstName = firstName;

    }
}
