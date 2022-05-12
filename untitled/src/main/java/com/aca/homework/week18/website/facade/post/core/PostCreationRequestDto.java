package com.aca.homework.week18.website.facade.post.core;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class PostCreationRequestDto {

    private final String title;
    private final String description;
    private final Long userId;
    private final List<Long> imagesBlobId;

    public PostCreationRequestDto(String title, String description, Long userId, List<Long> imagesBlobId) {
        Assert.hasText(title, "The title should not be null or empty");
        Assert.hasText(description, "The description should not be null or empty");
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(imagesBlobId, "the imagesId list should be null");
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.imagesBlobId = imagesBlobId;
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

    public List<Long> getImagesBlobId() {
        return imagesBlobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostCreationRequestDto)) return false;

        PostCreationRequestDto that = (PostCreationRequestDto) o;

        return Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId) && Objects.equals(imagesBlobId, that.imagesBlobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, userId, imagesBlobId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PostCreationRequestDto{");
        sb.append("title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", UserId=").append(userId);
        sb.append(", images=").append(imagesBlobId);
        sb.append('}');
        return sb.toString();
    }
}