package com.aca.homework.week18.website.service.impl;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long postId) {
        super(String.format("Post with the id %d not found", postId));
    }
}