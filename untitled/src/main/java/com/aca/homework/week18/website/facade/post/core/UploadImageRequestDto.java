package com.aca.homework.week18.website.facade.post.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UploadImageRequestDto {

    private final Long blobId;
    private final Long postId;

    public UploadImageRequestDto(Long blobId, Long postId) {
        Assert.notNull(blobId, "the blobId cannot be null");
        Assert.notNull(postId, "the postId cannot be null");
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
        if (!(o instanceof UploadImageRequestDto)) return false;

        UploadImageRequestDto that = (UploadImageRequestDto) o;

        return Objects.equals(blobId, that.blobId) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UploadImageRequestDto{");
        sb.append("blobId=").append(blobId);
        sb.append(", postId=").append(postId);
        sb.append('}');
        return sb.toString();
    }
}