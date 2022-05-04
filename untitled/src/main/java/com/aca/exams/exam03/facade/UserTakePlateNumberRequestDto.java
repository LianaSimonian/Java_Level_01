package com.aca.exams.exam03.facade;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserTakePlateNumberRequestDto {

    private Long passportId;
    private final String plateNumber;

    public UserTakePlateNumberRequestDto(Long passportId, String plateNumber) {
        Assert.notNull(passportId, "The passportId should not be null");
        Assert.hasText(plateNumber, "The plateNumber should not be null or empty");
        this.passportId = passportId;
        this.plateNumber = plateNumber;
    }

    public Long getPassportId() {
        return passportId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTakePlateNumberRequestDto)) return false;

        UserTakePlateNumberRequestDto that = (UserTakePlateNumberRequestDto) o;
        return Objects.equals(passportId, that.passportId) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportId, plateNumber);
    }

    @Override
    public String toString() {
        return "UserTakePlateNumberRequestDto{" +
                "passportId=" + passportId +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}