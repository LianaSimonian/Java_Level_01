package com.aca.exams.exam03.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLATE_NUMBERS")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plate_number", unique = true, nullable = false, length = 6)
    private String plateNumber;

    PlateNumber() {

    }

    public PlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlateNumber)) return false;
        PlateNumber that = (PlateNumber) o;
        return Objects.equals(id, that.id) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateNumber);
    }

    @Override
    public String toString() {
        return "PlateNumber{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
