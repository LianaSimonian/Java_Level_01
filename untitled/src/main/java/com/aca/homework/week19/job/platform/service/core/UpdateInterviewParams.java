package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.InterviewStatusType;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public final class UpdateInterviewParams {

    private final InterviewStatusType status;
    private final Long interviewId;
    private LocalDateTime dateTime;

    public UpdateInterviewParams(InterviewStatusType status, Long interviewId, LocalDateTime dateTime) {
        Assert.notNull(dateTime, "The dateTime should not be null");
        Assert.notNull(status, "The status should not be null");
        Assert.notNull(interviewId, "The interviewId cannot be null");
        this.interviewId = interviewId;
        this.status = status;
        this.dateTime = dateTime;
    }

    public InterviewStatusType getStatus() {
        return status;
    }

    public Long getInterviewId() {
        return interviewId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateInterviewParams)) return false;

        UpdateInterviewParams that = (UpdateInterviewParams) o;

        return Objects.equals(dateTime, that.dateTime) && Objects.equals(status, that.status) && Objects.equals(interviewId, that.interviewId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, status, interviewId);
    }

    @Override
    public String toString() {
        return "UpdateInterviewParams{" +
                "status=" + status +
                ", interviewId=" + interviewId +
                ", dateTime=" + dateTime +
                '}';
    }
}
