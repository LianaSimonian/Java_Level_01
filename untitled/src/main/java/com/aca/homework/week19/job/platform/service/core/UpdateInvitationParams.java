package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import org.springframework.util.Assert;

import java.util.Objects;

public final class UpdateInvitationParams {

    private final Long invitationId;
    private final Long userId;
    private final Long organizationId;
    private final InvitationStatusType status;

    public UpdateInvitationParams(Long invitationId, Long userId, Long organizationId, InvitationStatusType status) {
        Assert.notNull(invitationId, "The invitationId should not be null");
        Assert.notNull(status, "The status should not be null");
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(organizationId, "The organizationId should not be null");
        this.invitationId = invitationId;
        this.userId = userId;
        this.organizationId = organizationId;
        this.status = status;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public InvitationStatusType getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateInvitationParams)) return false;

        UpdateInvitationParams that = (UpdateInvitationParams) o;

        return Objects.equals(userId, that.userId) && Objects.equals(invitationId, that.invitationId) && Objects.equals(organizationId, that.organizationId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, invitationId, organizationId, status);
    }

    @Override
    public String toString() {
        return "UpdateInvitationParams{" +
                "invitationId=" + invitationId +
                ", userId=" + userId +
                ", organizationId=" + organizationId +
                ", status=" + status +
                '}';
    }
}