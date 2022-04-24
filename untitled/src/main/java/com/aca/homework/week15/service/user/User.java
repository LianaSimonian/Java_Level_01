package com.aca.homework.week15.service.user;

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
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }
}