package com.aca.homework.week21.post.facade.impl;

import com.aca.homework.week21.post.dto.CreatePostRequestDto;
import com.aca.homework.week21.post.dto.DeletePostResponseDto;
import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.facade.core.PostFacade;
import com.aca.homework.week21.post.mapper.core.PostMapper;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class PostFacadeImpl implements PostFacade {

    private final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);

    private final PostService postService;
    private final RandomFactService randomFactService;
    private final PostMapper postMapper;

    public PostFacadeImpl(PostService postService, RandomFactService randomFactService, PostMapper postMapper) {
        Assert.notNull(postService, "The provided postService should not be null");
        Assert.notNull(randomFactService, "The provided randomFactService should not be null");
        Assert.notNull(postMapper, "The provided postMapper should not be null");
        this.postService = postService;
        this.randomFactService = randomFactService;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto create(CreatePostRequestDto dto) {
        Assert.notNull(dto, "post request dto param should not be null");
        LOGGER.info("create the post according to the provided request - {}", dto);
        final Post post = postService.create(new CreatePostParams(
                LocalDateTime.of(2020, 04, 01, 12, 30),
                randomFactService.getRandomFact(),
                dto.getCreatedBy()
        ));
        PostDto responseDto = postMapper.map(post);
        LOGGER.info(" Successfully created the post according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        LOGGER.info("Retrieving all posts for provided request");
        List<PostDto> postDtos = new LinkedList<>();
        List<Post> posts = postService.findAll();
        posts.forEach(post -> postDtos.add(postMapper.map(post)));
        LOGGER.info("Successfully retrieved all posts for provided request, result -{} ", postDtos);
        return postDtos;
    }

    @Override
    public PostDto getById(Long id) {
        Assert.notNull(id, "post id should not be null");
        LOGGER.info("Retrieving post according to the provided id  - {}", id);
        Optional<Post> postOptional = postService.findById(id);
        if (postOptional.isEmpty())
            return new PostDto(List.of(String.format("post with id %d not found", id)));
        PostDto postDto = postMapper.map(postOptional.get());
        LOGGER.info("Successfully retrieved the post according to the provided id - {}, result - {}", id, postDto);
        return postDto;
    }

    @Override
    public DeletePostResponseDto deleteById(Long id) {
        Assert.notNull(id, "post id should not be null");
        LOGGER.info("Deleting post according to the provided id  - {}", id);
        try {
            postService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return new DeletePostResponseDto(id, List.of(String.format("post with id %d have not found", id)));
        }
        LOGGER.info("Successfully deleted the post according to the provided id - {}", id);
        return new DeletePostResponseDto(id, true);
    }
}