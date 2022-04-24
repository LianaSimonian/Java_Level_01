package com.aca;

public class CreateUserParams {

    private final String first_name;
    private final String second_name;

    public CreateUserParams(String first_name, String second_name) {
        this.first_name = first_name;
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }
}