package com.aca.exams.exam03.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class UserPlateNumberCreationParams {

    private final Long plateNumberId;
    private final Long userId;
    private final LocalDate creationDate;

    public UserPlateNumberCreationParams(Long plateNumberId, Long userId, LocalDate creationDate) {
        Assert.notNull(plateNumberId, "The plateNumberId should not be null");
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(creationDate, "The creationDate should not be null");
        this.plateNumberId = plateNumberId;
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public Long getPlateNumberId() {
        return plateNumberId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPlateNumberCreationParams)) return false;
        UserPlateNumberCreationParams that = (UserPlateNumberCreationParams) o;
        return Objects.equals(plateNumberId, that.plateNumberId) && Objects.equals(userId, that.userId) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumberId, userId, creationDate);
    }
}