package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        Assert.notNull(postRepository, "the postRepository cannot be null");
        this.postRepository = postRepository;
    }

    @Override
    public Post create(CreatePostParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating and saving a post for the provided params - {}", params);
        final Post transientPost = new Post(
                params.getCreationDate(),
                params.getContent(),
                params.getCreatedBy());
        Post persistentPost = postRepository.save(transientPost);
        LOGGER.info("Successfully created and saved a post for the provided params - {}", params);
        return persistentPost;
    }

    @Override
    public List<Post> findAll() {
        LOGGER.info("Retrieving all posts ");
        List<Post> posts = postRepository.findAll();
        LOGGER.info("Successfully retrieved all posts , result -{} ", posts);
        return posts;
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
    public void deleteById(Long id) {
        Assert.notNull(id, "post id should not be null");
        LOGGER.info("Deleting post for the provided id  - {}", id);
        postRepository.deleteById(id);
        LOGGER.info("Successfully deleted the post for the provided id - {}", id);
    }
}