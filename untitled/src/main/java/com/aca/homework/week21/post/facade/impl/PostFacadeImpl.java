package com.aca.homework.week21.post.facade.impl;

import com.aca.homework.week21.post.dto.*;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.facade.core.PostFacade;
import com.aca.homework.week21.post.mapper.core.PostMapper;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Component
public class PostFacadeImpl implements PostFacade {

    private final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);

    private final PostService postService;
    private final RandomFactService randomFactService;
    private final PostMapper postMapper;
    private final String bulkPostPrefix;

    public PostFacadeImpl(PostService postService, RandomFactService randomFactService, PostMapper postMapper, @Value("${bulk.post.prefix}") String bulkPostPrefix) {
        Assert.notNull(postService, "The provided postService should not be null");
        Assert.notNull(randomFactService, "The provided randomFactService should not be null");
        Assert.notNull(postMapper, "The provided postMapper should not be null");
        this.postService = postService;
        this.randomFactService = randomFactService;
        this.postMapper = postMapper;
        this.bulkPostPrefix = bulkPostPrefix;
    }

    @Override
    public PostDto createPost(CreatePostRequestDto dto) {
        Assert.notNull(dto, "post request dto param should not be null");
        LOGGER.info("create the post according to the provided request - {}", dto);
        final Post post = postService.create(new CreatePostParams(
                LocalDateTime.now(),
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

    @Override
    public CreatePostsResponseDto createPosts(CreatePostsRequestDto dto) {
        Assert.notNull(dto, "the posts request dto param should not be null");
        LOGGER.info("creating posts according to the provided request - {}", dto);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<PostDto>> futures = new LinkedList<>();
        final int count = dto.getCount();
        final String createdBy = dto.getCreatedBy();
        for (int i = 0; i < count; i++) {
            Future<PostDto> future = executor.submit(new Callable<PostDto>() {
                @Override
                public PostDto call() throws Exception {
                    Post post = postService.create(new CreatePostParams(
                            LocalDateTime.of(2020, 02, 02, 01, 01),
                            bulkPostPrefix + randomFactService.getRandomFact(),
                            createdBy
                    ));
                    return postMapper.map(post);
                }
            });
            futures.add(future);
        }
        List<PostDto> postDtos = new LinkedList<>();
        futures.forEach(future -> {
            try {
                postDtos.add(future.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdown();
        CreatePostsResponseDto responseDto = new CreatePostsResponseDto(postDtos);
        LOGGER.info(" Successfully created posts according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}