package com.aca.homework.week21.post.dto;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public final class PostDto {

    private LocalDateTime creationDate;

    private String content;

    private String createdBy;

    private List<String> errors;

    public PostDto(List<String> errors) {
        Assert.notNull(errors, "the errors list cannot be null");
        this.errors = errors;
    }

    public PostDto(LocalDateTime creationDate, String content, String createdBy) {
        Assert.hasText(content, "The content should not be null or empty");
        Assert.hasText(createdBy, "The createdBy should not be null or empty");
        Assert.notNull(creationDate, "The creationDate should not be null or empty");
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

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto postDto = (PostDto) o;
        return Objects.equals(creationDate, postDto.creationDate) && Objects.equals(content, postDto.content) && Objects.equals(createdBy, postDto.createdBy) && Objects.equals(errors, postDto.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, content, createdBy, errors);
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "creationDate=" + creationDate +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", errors=" + errors +
                '}';
    }
}
