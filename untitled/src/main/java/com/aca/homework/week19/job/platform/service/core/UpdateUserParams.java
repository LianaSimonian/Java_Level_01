package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UpdateUserParams {

    private final Long userId;
    private final String username;
    private final String password;
    private final boolean isOpenForJobOffers;

    public UpdateUserParams(Long userId, String username, String password, boolean isOpenForJobOffers) {
        Assert.hasText(username, "The text should not be null or empty");
        Assert.hasText(password, "The password should not be null or empty");
        Assert.notNull(userId, "The userId should not be null");
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.isOpenForJobOffers = isOpenForJobOffers;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOpenForJobOffers() {
        return isOpenForJobOffers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateUserParams)) return false;

        UpdateUserParams that = (UpdateUserParams) o;

        return Objects.equals(userId, that.userId) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(isOpenForJobOffers, that.isOpenForJobOffers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, isOpenForJobOffers);
    }

    @Override
    public String toString() {
        return "UpdateUserParams{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isOpenForJobOffers=" + isOpenForJobOffers +
                '}';
    }
}