package com.aca.homework.week15.service.user;

import java.util.Objects;

@Table(name = "USERS")
public class User {

    @Column(name = "username")
    private final String username;

    @Column(name = "name")
    private final String name;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Objects.equals(username, user.username) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name);
    }
}