package com.aca.classroom.week17.note.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public class UserSignUpResponseDto {

    private final String username;

    public UserSignUpResponseDto(String username) {
        Assert.hasText(username, "The username should not be null or empty");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserSignUpResponseDto{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpResponseDto)) return false;

        UserSignUpResponseDto that = (UserSignUpResponseDto) o;

        return Objects.equals(that.username, username);
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}