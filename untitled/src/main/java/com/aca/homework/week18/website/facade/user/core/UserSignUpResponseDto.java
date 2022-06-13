package com.aca.homework.week18.website.facade.user.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class UserSignUpResponseDto {

    private String firstName;
    private String secondName;
    private String username;
    private String password;
    private LocalDate signUpDate;

    private List<String> errors;

    public UserSignUpResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public UserSignUpResponseDto(String firstName, String secondName, String username, String password, LocalDate signUpDate) {
        Assert.hasText(firstName, "The firstName should not be null or empty");
        Assert.hasText(secondName, "The secondName should not be null or empty");
        Assert.hasText(username, "The username should not be null or empty");
        Assert.hasText(password, "The password should not be null or empty");
        Assert.notNull(signUpDate, "The signUpDate should not be null");
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
        this.signUpDate = signUpDate;
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

    public LocalDate getSignUpDate() {
        return signUpDate;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSignUpResponseDto)) return false;

        UserSignUpResponseDto that = (UserSignUpResponseDto) o;

        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(errors, that.errors) && Objects.equals(signUpDate, that.signUpDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, username, password, signUpDate, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserSignUpRequestDto{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", signUPDate= ").append(signUpDate);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}