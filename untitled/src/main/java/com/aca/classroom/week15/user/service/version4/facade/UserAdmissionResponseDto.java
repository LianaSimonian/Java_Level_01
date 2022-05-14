package com.aca.classroom.week15.user.service.version4.facade;

public class UserAdmissionResponseDto {

    private final String username;
    private final String firsName;
    private final String secondName;

    public UserAdmissionResponseDto(String username, String firsName, String secondName) {
        this.username = username;
        this.firsName = firsName;
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "UserAdmissionResponseDto{" +
                "username='" + username + '\'' +
                ", firsName='" + firsName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
