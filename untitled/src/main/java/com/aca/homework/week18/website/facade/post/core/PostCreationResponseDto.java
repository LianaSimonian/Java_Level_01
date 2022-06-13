package com.aca.homework.week18.website.facade.post.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class PostCreationResponseDto {

    private Long postId;
    private String title;
    private String description;
    private LocalDate postCreationDate;
    private Long userId;
    private List<Long> imagesBlobId;

    private List<String> errors;

    public PostCreationResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public PostCreationResponseDto(Long postId, String title, String description, Long userId, List<Long> imagesBlobId, LocalDate postCreationDate) {
        Assert.notNull(postId, "The postId should not be null ");
        Assert.hasText(title, "The title should not be null or empty");
        Assert.hasText(description, "The description should not be null or empty");
        Assert.notNull(userId, "The userId should not be null ");
        Assert.notNull(imagesBlobId, "The imagesBlobId should not be null");
        Assert.notNull(postCreationDate, "The postCreationDate should not be null");
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.imagesBlobId = imagesBlobId;
        this.postCreationDate = postCreationDate;
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

    public LocalDate getPostCreationDate() {
        return postCreationDate;
    }

    public Long getPostId() {
        return postId;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostCreationResponseDto)) return false;

        PostCreationResponseDto that = (PostCreationResponseDto) o;

        return Objects.equals(postId, that.postId) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId) && Objects.equals(imagesBlobId, that.imagesBlobId) && Objects.equals(postCreationDate, that.postCreationDate) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, description, userId, imagesBlobId, postCreationDate, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PostCreationResponseDto{");
        sb.append("postId=").append(postId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", imagesBlobId=").append(imagesBlobId);
        sb.append(", postCreationDate=").append(postCreationDate);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}