package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.InterviewStatusType;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public final class CreateInterviewParams {

    private final Long userId;
    private final LocalDateTime dateTime;
    private final InterviewStatusType status;
    private final Long organizationId;

    public CreateInterviewParams(Long userId, LocalDateTime dateTime, InterviewStatusType status, Long organizationId) {
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(dateTime, "The dateTime should not be null");
        Assert.notNull(status, "The status should not be null");
        Assert.notNull(organizationId, "The organizationId should not be null");
        this.userId = userId;
        this.dateTime = dateTime;
        this.status = status;
        this.organizationId = organizationId;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public InterviewStatusType getStatus() {
        return status;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateInterviewParams)) return false;

        CreateInterviewParams that = (CreateInterviewParams) o;
        return Objects.equals(userId, that.userId) && Objects.equals(dateTime, that.dateTime) && Objects.equals(status, that.status) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, dateTime, status, organizationId);
    }

    @Override
    public String toString() {
        return "CreateInterviewParams{" +
                "userId=" + userId +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", organizationId=" + organizationId +
                '}';
    }
}
