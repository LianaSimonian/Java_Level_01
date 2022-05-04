package com.aca.exams.exam03.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "passport_id", unique = true, nullable = false, length = 20)
    private String passportId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    User() {

    }

    public User(String passportId, String firstName, String secondName) {
        this.passportId = passportId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Long getId() {
        return id;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(passportId, user.passportId) && Objects.equals(firstName, ((User) o).firstName) && Objects.equals(secondName, ((User) o).secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passportId, firstName, secondName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passportId=" + passportId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    public static class UserPlateNumberRepository {
    }
}