package com.aca.homework.week18.website.facade.user.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserSignUpRequestDto {

    private final String firstName;
    private final String secondName;
    private final String username;
    private final String password;

    public UserSignUpRequestDto(String firstName, String secondName, String username, String password) {
        Assert.hasText(firstName, "The firstName should not be null or empty");
        Assert.hasText(secondName, "The secondName should not be null or empty");
        Assert.hasText(username, "The username should not be null or empty");
        Assert.hasText(password, "The password should not be null or empty");
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpRequestDto)) return false;

        UserSignUpRequestDto that = (UserSignUpRequestDto) o;

        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, username, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserSignUpRequestDto{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}