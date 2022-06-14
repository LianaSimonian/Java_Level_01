package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CreateUserParams {

    private final String firstName;
    private final String secondName;
    private final String username;
    private final String password;
    private final boolean isOpenForJobOffers;

    public CreateUserParams(String firstName, String secondName, String username, String password, boolean isOpenForJobOffers) {
        Assert.hasText(firstName, "The firstName should not be null or empty");
        Assert.hasText(secondName, "The secondName should not be null or empty");
        Assert.hasText(username, "The username should not be null or empty");
        Assert.hasText(password, "The password should not be null or empty");
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
        this.isOpenForJobOffers = isOpenForJobOffers;
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

    public boolean isOpenForJobOffers() {
        return isOpenForJobOffers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserParams)) return false;

        CreateUserParams that = (CreateUserParams) o;

        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(isOpenForJobOffers, that.isOpenForJobOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, username, password, isOpenForJobOffers);
    }

    @Override
    public String toString() {
        return "CreateUserParams{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isOpenForJobOffers=" + isOpenForJobOffers +
                '}';
    }
}