package com.aca.homework.week15.service.user;

public class UserCreateParams {

    @NotNull
    private final String username;
    @NotNull
    private final String name;

    public UserCreateParams(String username, String name) {
        if (username == null)
            throw new NullFieldException("username field can not be null");
        if (name == null)
            throw new NullFieldException("name field can not be null");
        this.username = username;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
}