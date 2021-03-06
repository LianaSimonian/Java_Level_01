package com.aca.classroom.week15.user.service.version5.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;

public class CreateUserParams {

    private final String username;
    private final String firstName;
    private final String secondName;
    private final LocalDate createdAt;
    private final String password;

    public CreateUserParams(String username, String firstName, String secondName, LocalDate createdAt, String password) {
        Assert.hasText(firstName, "The first name should not be null or empty");
        Assert.hasText(secondName, "The second name should not be null or empty");
        Assert.hasText(username, "The username should not be null or empty");
        Assert.notNull(createdAt, "The created date  should not be null or empty");
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.createdAt = createdAt;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "CreateUserParams{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", createdAt=" + createdAt +
                ", password=" + password +
                '}';
    }
}