package com.aca.homework.week21.post.service.core;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

public final class CreatePostParams {

    private final LocalDateTime creationDate;

    private final String content;

    private final String createdBy;

    public CreatePostParams(LocalDateTime creationDate, String content, String createdBy) {
        Assert.notNull(creationDate, "Creation date should not be null");
        Assert.hasText(content, "Content date should not be null or empty");
        Assert.hasText(createdBy, "CreatedBy should not be null or empty");
        this.creationDate = creationDate;
        this.content = content;
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePostParams that = (CreatePostParams) o;
        return Objects.equals(creationDate, that.creationDate) && Objects.equals(content, that.content) && Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, content, createdBy);
    }

    @Override
    public String toString() {
        return "PostCreationParams{" +
                "creationDate=" + creationDate +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
