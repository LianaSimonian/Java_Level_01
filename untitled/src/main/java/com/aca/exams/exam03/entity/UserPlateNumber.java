package com.aca.exams.exam03.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "USER_PLATE_NUMBERS")
public class UserPlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "plate_number_id", foreignKey = @ForeignKey(name = "FK_USER_PLATE_NUMBERS_ID_PLATE_NUMBERS_PLATE_NUMBER"), nullable = false)
    private PlateNumber plateNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_PLATE_NUMBERS_ID_USERS_ID"), nullable = false)
    private User user;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    UserPlateNumber() {
    }

    public UserPlateNumber(PlateNumber plateNumber, User user, LocalDate creationDate) {
        this.plateNumber = plateNumber;
        this.user = user;
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPlateNumber)) return false;
        UserPlateNumber that = (UserPlateNumber) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNumber, that.plateNumber) && Objects.equals(user, that.user) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNumber, user, creationDate);
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
}