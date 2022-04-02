package com.aca.homework.week12.params;

public class UserCreateParams {
    @NotNull
    private final String userName;
    @NotNull
    private final String firstName;
    @NotNegative
    private int age;

    public UserCreateParams(String userName, String firstName, int age) {
        if (userName == null) throw new IllegalArgumentException("username can not be  null");
        if (firstName == null) throw new IllegalArgumentException("firstname can not be null");
        if (age < 0) throw new IllegalArgumentException("age can not be  negative");
        this.userName = userName;
        this.firstName = firstName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserName() {
        return userName;
    }
}