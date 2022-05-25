package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class CreateUserOrganizationParams {

    private final Long userId;
    private final Long organizationId;
    private final LocalDate startDate;

    public CreateUserOrganizationParams(Long userId, Long organizationId, LocalDate startDate) {
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(startDate, "The startDate should not be null");
        Assert.notNull(organizationId, "The organizationId should not be null");
        this.userId = userId;
        this.organizationId = organizationId;
        this.startDate = startDate;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserOrganizationParams)) return false;

        CreateUserOrganizationParams that = (CreateUserOrganizationParams) o;

        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId, startDate);
    }

    @Override
    public String toString() {
        return "CreateUserOrganizationParams{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                ", startDate=" + startDate +
                '}';
    }
}
