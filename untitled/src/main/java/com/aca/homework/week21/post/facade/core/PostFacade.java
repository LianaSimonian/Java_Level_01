package com.aca.homework.week21.post.facade.core;

import com.aca.homework.week21.post.dto.CreatePostRequestDto;
import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.dto.DeletePostResponseDto;

import java.util.List;


public interface PostFacade {

    PostDto create(CreatePostRequestDto dto);

    List<PostDto> getAllPosts();

    PostDto getById(Long id);

    DeletePostResponseDto deleteById(Long id);
}