package com.aca.homework.week18.website.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CreateImageParams {

    private final Long blobId;
    private final Long postId;

    public CreateImageParams(Long blobId, Long postId) {
        Assert.notNull(blobId, "The blobId should not be null");
        Assert.notNull(postId, "The postId should not be null");
        this.blobId = blobId;
        this.postId = postId;
    }

    public Long getBlobId() {
        return blobId;
    }

    public Long getPostId() {
        return postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateImageParams)) return false;

        CreateImageParams that = (CreateImageParams) o;

        return Objects.equals(blobId, that.blobId) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CreateImageParams{");
        sb.append("blobId=").append(blobId);
        sb.append(", postId=").append(postId);
        sb.append('}');
        return sb.toString();
    }
}