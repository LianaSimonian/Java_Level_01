package com.aca.homework.week18.website.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class CreatePostParams {

    private final String title;
    private final String description;
    private final Long userId;
    private final LocalDate creationDate;

    public CreatePostParams(String title, String description, Long userId, LocalDate creationDate) {
        Assert.hasText(title, "The title should not be null or empty");
        Assert.hasText(description, "The description should not be null or empty");
        Assert.notNull(userId, "The userId should not be null");
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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
        if (!(o instanceof CreatePostParams)) return false;

        CreatePostParams that = (CreatePostParams) o;

        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, userId, creationDate);
    }

    @Override
    public String toString() {
        return "CreatePostParams{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                '}';
    }
}