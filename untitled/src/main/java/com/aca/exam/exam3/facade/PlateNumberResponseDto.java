package com.aca.exam.exam3.facade;

import java.time.LocalDate;
import java.util.Objects;

public final class PlateNumberResponseDto {

    private final Long userId;
    private final String plateNumber;
    private final LocalDate creationDate;

    public PlateNumberResponseDto(Long userId, String plateNumber, LocalDate creationDate) {
        this.userId = userId;
        this.plateNumber = plateNumber;
        this.creationDate = creationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "PlateNumberResponseDto{" +
                "passportId=" + userId +
                ", plateNumber='" + plateNumber + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlateNumberResponseDto)) return false;

        PlateNumberResponseDto that = (PlateNumberResponseDto) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (plateNumber != null ? !plateNumber.equals(that.plateNumber) : that.plateNumber != null) return false;
        return creationDate != null ? creationDate.equals(that.creationDate) : that.creationDate == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, plateNumber, creationDate);
    }
}
