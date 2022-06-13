package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week17.note.service.impl.UserNoteFoundException;
import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.repository.PostRepository;
import com.aca.homework.week18.website.service.core.CreatePostParams;
import com.aca.homework.week18.website.service.core.ImageService;
import com.aca.homework.week18.website.service.core.PostService;
import com.aca.homework.week18.website.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        Assert.notNull(postRepository, "the postRepository cannot be null");
        Assert.notNull(userService, "the userService cannot be null");
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Post create(CreatePostParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving a post for the provided params - {}", params);
        final Optional<User> userOptional = userService.findById(params.getUserId());
        final User user = userOptional.orElseThrow(() -> new UserNoteFoundException(params.getUserId()));

        final Post transientPost = new Post(
                params.getTitle(),
                params.getDescription(),
                userOptional.get(),
                params.getCreationDate()
        );

        final Post persistentPost = postRepository.save(transientPost);
        LOGGER.info("Successfully created a post for the provided params - {}", params);
        return persistentPost;
    }

    @Override
    public Optional<Post> findById(Long id) {
        Assert.notNull(id, "post id should not be null");
        LOGGER.info("Retrieving post for the provided id  - {}", id);
        final Optional<Post> postOptional = postRepository.findById(id);
        LOGGER.info("Successfully retrieved the post for the provided id - {}, result - {}", id, postOptional);
        return postOptional;
    }

    @Override
    public List<Post> findAllByUserId(Long id) {
        Assert.notNull(id, "user id should not be null");
        LOGGER.info("Retrieving posts for the provided user id  - {}", id);
        final List<Post> posts = postRepository.findAllByUserId(id);
        LOGGER.info("Successfully retrieved  all posts for the provided user id - {}, result - {}", id, posts);
        return posts;
    }
}