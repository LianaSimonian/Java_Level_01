package com.aca.homework.week19.job.platform.dto;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class UserDetailsDto {

    private String firstName;
    private String secondName;
    private String username;
    private String password;
    private boolean isOpenForJobOffers;

    private List<String> errors;

    public UserDetailsDto(List<String> errors) {
        Assert.notNull(errors, "the errors list cannot be null");
        this.errors = errors;
    }

    public UserDetailsDto(String firstName, String secondName, String username, String password, boolean isOpenForJobOffers) {
        Assert.hasText(firstName, "the firstName cannot be null or empty");
        Assert.hasText(secondName, "the secondName cannot be null or empty");
        Assert.hasText(username, "the username cannot be null or empty");
        Assert.hasText(password, "the password cannot be null or empty");
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

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailsDto)) return false;

        UserDetailsDto that = (UserDetailsDto) o;

        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(errors, that.errors) && Objects.equals(isOpenForJobOffers, that.isOpenForJobOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, username, password, isOpenForJobOffers, errors);
    }

    @Override
    public String toString() {
        return "UserDetailsDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isOpenForJobOffers=" + isOpenForJobOffers +
                ", errors=" + errors +
                '}';
    }
}