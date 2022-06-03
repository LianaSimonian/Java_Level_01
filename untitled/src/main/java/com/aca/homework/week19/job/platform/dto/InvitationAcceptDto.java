package com.aca.homework.week19.job.platform.dto;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public final class InvitationAcceptDto {

    private final Long userId;
    private final Long invitationId;
    private final LocalDateTime interviewDateTime;

    public InvitationAcceptDto(Long userId, Long invitationId, LocalDateTime interviewDateTime) {
        Assert.notNull(userId, "The userId cannot be null");
        Assert.notNull(invitationId, "the invitationId cannot be null");
        Assert.notNull(interviewDateTime, "the interviewDateTime cannot be null");
        this.userId = userId;
        this.invitationId = invitationId;
        this.interviewDateTime = interviewDateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public LocalDateTime getInterviewDateTime() {
        return interviewDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvitationAcceptDto)) return false;

        InvitationAcceptDto that = (InvitationAcceptDto) o;

        return Objects.equals(userId, that.userId) && Objects.equals(invitationId, that.invitationId) && Objects.equals(interviewDateTime, that.interviewDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, invitationId, interviewDateTime);
    }

    @Override
    public String toString() {
        return "InvitationAcceptDto{" +
                "userId=" + userId +
                ", invitationId=" + invitationId +
                ", interviewDateTime=" + interviewDateTime +
                '}';
    }
}