package com.aca.homework.week3.license.covid.test.license.covid.test;

public class User {
    private String username;
    private String name;

    User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
