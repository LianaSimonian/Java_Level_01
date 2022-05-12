package com.aca.homework.week18.website.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CreateUserParams {

    private final String firstName;
    private final String secondName;
    private final String username;
    private final String password;

    public CreateUserParams(String firstName, String secondName, String username, String password) {
        Assert.hasText(firstName, "The first name should not be null or empty");
        Assert.hasText(secondName, "The second name should not be null or empty");
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
        if (!(o instanceof CreateUserParams)) return false;

        CreateUserParams that = (CreateUserParams) o;

        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, username, password);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("CreateUserParams{");
        stringBuilder.append("firstName='").append(firstName).append('\'');
        stringBuilder.append(", secondName='").append(secondName).append('\'');
        stringBuilder.append(", username='").append('\'');
        stringBuilder.append(", password='").append(password).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}