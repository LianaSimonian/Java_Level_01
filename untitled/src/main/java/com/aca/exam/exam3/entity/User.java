package com.aca.exam.exam3.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "passport-id", unique = true, nullable = false, length = 20)
    private Long passportId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    User() {

    }

    public User(Long passportId, String firstName, String secondName) {
        this.passportId = passportId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Long getId() {
        return id;
    }

    public Long getPassportId() {
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

    public void setPassportId(Long passportId) {
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
        return Objects.equals(passportId, ((User) o).passportId) && Objects.equals(firstName, ((User) o).firstName) && Objects.equals(secondName, ((User) o).secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId, firstName, secondName);
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
}
