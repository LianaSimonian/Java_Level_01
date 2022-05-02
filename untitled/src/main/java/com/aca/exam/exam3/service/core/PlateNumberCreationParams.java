package com.aca.exam.exam3.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class PlateNumberCreationParams {

    private final String  plateNumber;
    private final Long userId;
    private final LocalDate creationDate;

    public PlateNumberCreationParams(String plateNumber, Long userId,LocalDate creationDate) {
        Assert.notNull(plateNumber, "The plateNumber should not be null or empty");
        Assert.notNull(userId, "The userId should not be null or empty");
        Assert.notNull(creationDate,"The creationDate should not be null or empty");
        this.plateNumber = plateNumber;
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "PlateNumberCreationParams{" +
                "plateNumber=" + plateNumber +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlateNumberCreationParams)) return false;

        PlateNumberCreationParams that = (PlateNumberCreationParams) o;

        if (plateNumber != null ? !plateNumber.equals(that.plateNumber) : that.plateNumber != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return creationDate != null ? creationDate.equals(that.creationDate) : that.creationDate == null;
    }

    @Override
    public int hashCode() {
        int result = plateNumber != null ? plateNumber.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}
