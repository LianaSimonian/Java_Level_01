package com.aca.homework.week21.post.dto;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CreatePostRequestDto {

    private String createdBy;

    public CreatePostRequestDto() {

    }

    public CreatePostRequestDto(String createdBy) {
        Assert.hasText(createdBy, "the createdBy should not be null or empty");
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePostRequestDto that = (CreatePostRequestDto) o;
        return Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy);
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "createdBy='" + createdBy + '\'' +
                '}';
    }
}