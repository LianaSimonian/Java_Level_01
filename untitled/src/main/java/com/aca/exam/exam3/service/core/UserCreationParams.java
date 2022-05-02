package com.aca.exam.exam3.service.core;

import org.springframework.util.Assert;


public final class UserCreationParams {

    private final Long passportId;
    private final String firstName;
    private final String secondName;

    public UserCreationParams(Long passportId, String firstName, String secondName) {
        Assert.hasText(firstName, "The first name should not be null or empty");
        Assert.hasText(secondName, "The second name should not be null or empty");
        Assert.notNull(passportId, "The passpordId should not be null or empty");
        this.passportId = passportId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Long getPassportId() {
        return passportId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "UserCreationParams{" +
                "passportId=" + passportId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCreationParams)) return false;

        UserCreationParams that = (UserCreationParams) o;

        if (passportId != null ? !passportId.equals(that.passportId) : that.passportId != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return secondName != null ? secondName.equals(that.secondName) : that.secondName == null;
    }

    @Override
    public int hashCode() {
        int result = passportId != null ? passportId.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }
}
