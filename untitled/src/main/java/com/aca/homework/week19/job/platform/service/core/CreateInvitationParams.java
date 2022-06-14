package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import org.springframework.util.Assert;

import java.util.Objects;

public final class CreateInvitationParams {

    private final Long userId;
    private final Long organizationId;
    private final InvitationStatusType status;

    public CreateInvitationParams(Long userId, Long organizationId, InvitationStatusType status) {
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(organizationId, "The organizationId should not be null");
        Assert.notNull(status, "The status should not be null");
        this.userId = userId;
        this.organizationId = organizationId;
        this.status = status;
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
        if (!(o instanceof CreateInvitationParams)) return false;

        CreateInvitationParams that = (CreateInvitationParams) o;

        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId, status);
    }

    @Override
    public String toString() {
        return "CreateInvitationParams{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                ", status=" + status +
                '}';
    }
}