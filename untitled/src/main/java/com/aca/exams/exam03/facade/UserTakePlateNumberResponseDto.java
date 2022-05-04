package com.aca.exams.exam03.facade;

import org.springframework.util.Assert;

public final class UserTakePlateNumberResponseDto {

    private final String plateNumber;

    public UserTakePlateNumberResponseDto(String plateNumber) {
        Assert.notNull(plateNumber, "The plateNumber should not be null");
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTakePlateNumberResponseDto)) return false;

        UserTakePlateNumberResponseDto that = (UserTakePlateNumberResponseDto) o;

        return plateNumber != null ? plateNumber.equals(that.plateNumber) : that.plateNumber == null;
    }

    @Override
    public int hashCode() {
        return plateNumber != null ? plateNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UserTakePlateNumberResponseDto{" +
                "plateNumber='" + plateNumber + '\'' +
                '}';
    }
}