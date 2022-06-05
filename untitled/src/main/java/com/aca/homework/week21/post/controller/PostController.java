package com.aca.homework.week21.post.controller;

import com.aca.homework.week21.post.dto.CreatePostRequestDto;
import com.aca.homework.week21.post.dto.PostDto;
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
    public PostDto create(@RequestBody CreatePostRequestDto dto) {
        return postFacade.create(dto);
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