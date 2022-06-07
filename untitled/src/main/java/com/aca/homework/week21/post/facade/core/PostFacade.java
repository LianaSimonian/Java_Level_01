package com.aca.homework.week21.post.facade.core;

import com.aca.homework.week21.post.dto.*;

import java.util.List;


public interface PostFacade {

    PostDto createPost(CreatePostRequestDto dto);

    CreatePostsResponseDto createPosts(CreatePostsRequestDto dto);

    List<PostDto> getAllPosts();

    PostDto getById(Long id);

    DeletePostResponseDto deleteById(Long id);
}