package com.aca.exams.exam03.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserCreationParams {

    private final String passportId;
    private final String firstName;
    private final String secondName;

    public UserCreationParams(String passportId, String firstName, String secondName) {
        Assert.hasText(firstName, "The first name should not be null or empty");
        Assert.hasText(secondName, "The second name should not be null or empty");
        Assert.hasText(passportId, "The passportId should not be null or empty");
        this.passportId = passportId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCreationParams)) return false;
        UserCreationParams that = (UserCreationParams) o;
        return Objects.equals(passportId, that.passportId) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId, firstName, secondName);
    }

    @Override
    public String toString() {
        return "UserCreationParams{" +
                "passportId='" + passportId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}