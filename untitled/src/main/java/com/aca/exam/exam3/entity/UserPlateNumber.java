package com.aca.exam.exam3.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USERPLATENUMBERS")
public class UserPlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plate_number", nullable = false)
    private String plateNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_PLATE_NUMBERS_ID_USERS_ID"), nullable = false)
    private User user;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    public UserPlateNumber() {

    }

    public UserPlateNumber(String plateNumber, User user, LocalDate creationDate) {
        this.plateNumber = plateNumber;
        this.user = user;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "UserPlateNumber{" +
                "id=" + id +
                ", plateNumber=" + plateNumber +
                ", user=" + user +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPlateNumber)) return false;

        UserPlateNumber that = (UserPlateNumber) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (plateNumber != null ? !plateNumber.equals(that.plateNumber) : that.plateNumber != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return creationDate != null ? creationDate.equals(that.creationDate) : that.creationDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (plateNumber != null ? plateNumber.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
