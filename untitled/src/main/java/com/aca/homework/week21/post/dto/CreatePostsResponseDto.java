package com.aca.homework.week21.post.dto;

import com.aca.homework.week21.post.dto.PostDto;

import java.util.List;
import java.util.Objects;

public class CreatePostsResponseDto {

    private List<PostDto> posts;

    public CreatePostsResponseDto(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePostsResponseDto that = (CreatePostsResponseDto) o;
        return Objects.equals(posts, that.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts);
    }

    @Override
    public String toString() {
        return "CreatePostsResponseDto{" +
                "posts=" + posts +
                '}';
    }
}
