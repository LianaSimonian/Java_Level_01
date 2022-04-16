package com.aca.homework.week12.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("username")
    private String userName;

    @JsonProperty("name")
    private String firstName;

    @JsonProperty("age")
    private String age;

    public User(String userName, String firstName, String age) {
        this.userName = userName;
        this.firstName = firstName;
        this.age = age;
    }
}