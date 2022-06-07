package com.aca.homework.week21.post.controller;

import com.aca.homework.week21.post.dto.CreatePostRequestDto;
import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.dto.CreatePostsRequestDto;
import com.aca.homework.week21.post.dto.CreatePostsResponseDto;
import com.aca.homework.week21.post.facade.core.PostFacade;
import com.aca.homework.week21.post.dto.DeletePostResponseDto;
import io.jsonwebtoken.lang.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "posts")
public final class PostController {

    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        Assert.notNull(postFacade, "the postFacade cannot be null");
        this.postFacade = postFacade;
    }

    @PostMapping
    public PostDto createPost(@RequestBody CreatePostRequestDto dto) {
        return postFacade.createPost(dto);
    }

    @PostMapping("/bulk")
    public CreatePostsResponseDto createPosts(@RequestBody CreatePostsRequestDto dto) {
        return postFacade.createPosts(dto);
    }

    @GetMapping("/{id}")
    public PostDto get(@PathVariable Long id) {
        return postFacade.getById(id);
    }

    @DeleteMapping("/{id}")
    public DeletePostResponseDto delete(@PathVariable Long id) {
        return postFacade.deleteById(id);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postFacade.getAllPosts();
    }
}