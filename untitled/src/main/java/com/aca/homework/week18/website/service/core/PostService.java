package com.aca.homework.week18.website.service.core;

import com.aca.homework.week18.website.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post create(CreatePostParams params);

    Optional<Post> findById(Long id);

    List<Post> findAllByUserId(Long id);
}