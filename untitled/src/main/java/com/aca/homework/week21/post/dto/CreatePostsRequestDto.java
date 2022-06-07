package com.aca.homework.week21.post.dto;

import java.util.Objects;

public class CreatePostsRequestDto {

    private String createdBy;

    private int count;

    public CreatePostsRequestDto() {

    }

    public CreatePostsRequestDto(String createdBy, int count) {
        //TODO add assertions
        this.createdBy = createdBy;
        this.count = count;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePostsRequestDto that = (CreatePostsRequestDto) o;
        return count == that.count && Objects.equals(createdBy, that.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, count);
    }

    @Override
    public String toString() {
        return "CreatePostsRequestDto{" +
                "createdBy='" + createdBy + '\'' +
                ", count=" + count +
                '}';
    }
}
