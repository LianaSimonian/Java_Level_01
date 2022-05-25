package com.aca.homework.week19.job.platform.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQUENCE")
    @SequenceGenerator(name = "USER_ID_SEQUENCE")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 7)
    private String firstName;

    @Column(name = "second_name", nullable = false, length = 15)
    private String secondName;

    @Column(name = "username", unique = true, nullable = false, length = 10)
    private String username;

    @Column(name = "password", unique = true, nullable = false, length = 20)
    private String password;

    @Column(name = "is_open_for_job_offers", nullable = false)
    private boolean isOpenForJobOffers;

    User() {
    }

    public User(String firstName, String secondName, String username, String password, boolean isOpenForJobOffers) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.password = password;
        this.isOpenForJobOffers = isOpenForJobOffers;
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

    public boolean isOpenForJobOffers() {
        return isOpenForJobOffers;
    }

    public void setOpenForJobOffers(boolean openForJobOffers) {
        isOpenForJobOffers = openForJobOffers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(isOpenForJobOffers, user.isOpenForJobOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, username, password, isOpenForJobOffers);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", isOpenForJobOffers=" + isOpenForJobOffers +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}