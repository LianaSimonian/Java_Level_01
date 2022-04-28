package com.aca.classroom.week15.user.service.simplestart.version;

public class CreateUserParams {

    private final String firstName;
    private final String secondName;

    public CreateUserParams(final String firstName, final String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}