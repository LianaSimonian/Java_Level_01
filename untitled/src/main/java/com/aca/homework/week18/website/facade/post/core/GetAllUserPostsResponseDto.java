package com.aca.homework.week18.website.facade.post.core;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class GetAllUserPostsResponseDto {

    private Long userId;
    private List<Long> postsId;
    private List<List<Long>> imagesId;

    private List<String> errors;

    public GetAllUserPostsResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public GetAllUserPostsResponseDto(Long userId, List<Long> postsId, List<List<Long>> imagesId) {
        Assert.notNull(userId, "The userId should not be null");
        Assert.notNull(postsId, "The postsId should not be null");
        Assert.notNull(imagesId, "The postsId should not be null");
        this.userId = userId;
        this.postsId = postsId;
        this.imagesId = imagesId;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Long> getPostsId() {
        return postsId;
    }

    public List<List<Long>> getImagesId() {
        return imagesId;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserPostsResponseDto)) return false;

        GetAllUserPostsResponseDto that = (GetAllUserPostsResponseDto) o;

        return Objects.equals(userId, that.userId) && Objects.equals(postsId, that.postsId) && Objects.equals(errors, that.errors) && Objects.equals(imagesId,that.imagesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, postsId,imagesId, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GetAllUserPostsResponseDto{");
        sb.append("userId=").append(userId);
        sb.append(", postsId=").append(postsId);
        sb.append(", imagesId=").append(imagesId);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}