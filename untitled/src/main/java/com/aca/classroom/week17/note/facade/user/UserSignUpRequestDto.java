package com.aca.classroom.week17.note.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public class UserSignUpRequestDto {

    private final String username;
    private final String firstName;
    private final String secondName;

    public UserSignUpRequestDto(String username, String firstName, String secondName) {
        Assert.hasText(firstName, "The first name should not be null or empty");
        Assert.hasText(secondName, "The second name should not be null or empty");
        Assert.hasText(username, "The username should not be null or empty");
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "UserSignUpRequestDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpRequestDto)) return false;

        UserSignUpRequestDto that = (UserSignUpRequestDto) o;

        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName);
    }
}