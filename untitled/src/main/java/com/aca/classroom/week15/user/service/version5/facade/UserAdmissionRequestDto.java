package com.aca.classroom.week15.user.service.version5.facade;

public class UserAdmissionRequestDto {

    private String firstName;
    private String secondName;

    UserAdmissionRequestDto() {

    }

    public UserAdmissionRequestDto(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "UserAdmissionRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
