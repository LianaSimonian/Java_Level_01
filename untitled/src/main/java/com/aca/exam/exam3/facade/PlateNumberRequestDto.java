package com.aca.exam.exam3.facade;

import org.springframework.util.Assert;

public final class PlateNumberRequestDto {

    private final Long userId;

    public PlateNumberRequestDto(Long userId) {
        Assert.notNull(userId, "The userId should not be null or empty");
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "PlateNumberRequestDto{" +
                "passportId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlateNumberRequestDto)) return false;

        PlateNumberRequestDto that = (PlateNumberRequestDto) o;

        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}