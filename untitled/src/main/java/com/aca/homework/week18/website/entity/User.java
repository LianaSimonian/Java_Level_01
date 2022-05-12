package com.aca.homework.week18.website.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 7)
    private String firstName;

    @Column(name = "second_name", nullable = false, length = 15)
    private String secondName;

    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;

    @Column(name = "password", nullable = false, unique = true, length = 20)
    private String password;

    User() {

    }

    public User(String firstName, String secondName, String username, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, username, password);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("User{");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(", firstName='").append(firstName).append('\'');
        stringBuilder.append(", secondName='").append(secondName).append('\'');
        stringBuilder.append(", username='").append(username).append('\'');
        stringBuilder.append(", passwordId='").append(password);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}