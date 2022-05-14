package com.aca.classroom.week15.user.service.version04.service.core;

import com.aca.classroom.week15.user.service.version04.entity.DiplomaColorType;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public class CreateDiplomaParams {

    private final DiplomaColorType colorType;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Long userId;

    public CreateDiplomaParams(DiplomaColorType colorType, LocalDate startDate, LocalDate endDate, Long userId) {
        Assert.hasText(colorType.name(), "The colorType should not be null");//?????notnull
        Assert.hasText(startDate.toString(), "The startDate should not be null");
        Assert.hasText(endDate.toString(), "The endDate should not be null");
        Assert.notNull(userId, "The user id should not be null");
        this.colorType = colorType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateDiplomaParams that = (CreateDiplomaParams) o;

        return colorType == that.colorType && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorType, startDate, endDate, userId);
    }

    public DiplomaColorType getColorType() {
        return colorType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getUserId() {
        return userId;
    }
}