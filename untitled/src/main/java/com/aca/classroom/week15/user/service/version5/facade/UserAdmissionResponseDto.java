package com.aca.classroom.week15.user.service.version5.facade;

public class UserAdmissionResponseDto {

    private final String username;
    private final String firstName;
    private final String secondName;

    public UserAdmissionResponseDto(String username, String firsName, String secondName) {
        this.username = username;
        this.firstName = firsName;
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
        return "UserAdmissionResponseDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
