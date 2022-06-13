package com.aca.homework.week18.website.facade.post.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class UploadImageResponseDto {

    private Long blobId;
    private Long postId;

    private List<String> errors;

    public UploadImageResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public UploadImageResponseDto(Long blobId, Long postId) {
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

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadImageResponseDto)) return false;

        UploadImageResponseDto that = (UploadImageResponseDto) o;

        return Objects.equals(blobId, that.blobId) && Objects.equals(postId, that.postId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobId, postId, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UploadImageResponseDto{");
        sb.append("blobId=").append(blobId);
        sb.append(", postId=").append(postId);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}