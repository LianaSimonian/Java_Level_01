package com.aca.homework.week18.website.service.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.repository.ImageRepository;
import com.aca.homework.week18.website.service.core.CreateImageParams;
import com.aca.homework.week18.website.service.core.ImageService;
import com.aca.homework.week18.website.service.core.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageRepository imageRepository;
    private final PostService postService;

    public ImageServiceImpl(ImageRepository imageRepository, PostService postService) {
        Assert.notNull(imageRepository, "imageRepository cannot be null");
        Assert.notNull(postService, "The postService cannot be null");
        this.imageRepository = imageRepository;
        this.postService = postService;
    }

    @Override
    public Image create(CreateImageParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating end saving image for the provided params - {}", params);
        final Optional<Post> postOptional = postService.findById(params.getPostId());
        Post post = postOptional.orElseThrow(() -> new PostNotFoundException(params.getPostId()));

        final Image transientImage = new Image(
                params.getBlobId(),
                post);

        final Image persistentImage = imageRepository.save(transientImage);
        LOGGER.info("Successfully created end saved a image for the provided params - {},", params);
        return persistentImage;
    }

    @Override
    public Optional<Image> findById(Long id) {
        Assert.notNull(id, "the id cannot be null");
        LOGGER.info("Retrieving image for the provided id - {}", id);
        final Optional<Image> imageOptional = imageRepository.findById(id);
        LOGGER.info("Successfully retrieved the image for the provided id - {}, result - {}", id, imageOptional);
        return imageOptional;
    }

    @Override
    public List<Image> findAllByPostId(Long id) {
        Assert.notNull(id, "the post id cannot be null");
        LOGGER.info("Retrieving all images for the provided post id - {}");
        List<Image> images = imageRepository.findAllByPostId(id);
        LOGGER.info("Successfully retrieved the imageList for the provided post id - {}, result - {}", id, images);
        return images;
    }
}