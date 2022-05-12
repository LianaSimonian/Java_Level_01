package com.aca.homework.week18.website.facade.post.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.post.core.*;
import com.aca.homework.week18.website.service.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PostFacadeImpl implements PostFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostFacadeImpl.class);

    private final PostService postService;
    private final UserService userService;
    private final ImageService imageService;
    private final ImageMapper imageMapper;
    private final PostMapper postMapper;

    public PostFacadeImpl(PostService postService, UserService userService, ImageService imageService, ImageMapper imageMapper, PostMapper postMapper) {
        Assert.notNull(postService, "The provided postService should not be null");
        Assert.notNull(userService, "The provided userService should not be null");
        Assert.notNull(imageService, "The provided imageService should not be null");
        Assert.notNull(imageMapper, "The provided imageMapper should not be null");
        Assert.notNull(postMapper, "The provided postMapper should not be null");
        this.postService = postService;
        this.userService = userService;
        this.imageService = imageService;
        this.imageMapper = imageMapper;
        this.postMapper = postMapper;
    }

    @Override
    public PostCreationResponseDto create(PostCreationRequestDto dto) {
        Assert.notNull(dto, "post creation request dto param should not be null");
        LOGGER.info("creating the post  according to the provided request - {}", dto);
        List<Long> imagesBlobId = dto.getImagesBlobId();

        if (imagesBlobId.size() > 5) {
            return new PostCreationResponseDto(List.of(String.format("the number %d of uploaded images can not be greater than %d ", imagesBlobId.size(), 5)));
        }

        Long userId = dto.getUserId();
        final Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new PostCreationResponseDto(List.of(String.format("User with id %d not found", userId)));
        }

        final Post post = postService.create(
                new CreatePostParams(
                        dto.getTitle(),
                        dto.getDescription(),
                        userId
                )
        );

        imagesBlobId.forEach(image -> {
            uploadImage(new UploadImageRequestDto(image, post.getId()));
        });
        PostCreationResponseDto responseDto = postMapper.mapper(post, imagesBlobId);
        LOGGER.info(" Successfully created post according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }

    @Override
    public UploadImageResponseDto uploadImage(UploadImageRequestDto dto) {
        Assert.notNull(dto, "upload image request dto param should not be null");
        LOGGER.info("uploading new  image  according to the provided request - {}", dto);
        Optional<Post> postOptional = postService.findById(dto.getPostId());

        if (postOptional.isEmpty()) {
            return new UploadImageResponseDto(List.of(String.format("post with id %d not found", dto.getPostId())));
        }

        Image image = imageService.create(new CreateImageParams(
                dto.getBlobId(),
                dto.getPostId()
        ));

        UploadImageResponseDto responseDto = imageMapper.mapper(image);
        LOGGER.info("Successfully uploaded new  image  according to the provided request - {},result -{}", dto, responseDto);
        return responseDto;
    }

    @Override
    public GetAllUserPostsResponseDto getAllUserPosts(GetAllUserPostsRequestDto dto) {
        Assert.notNull(dto, "get all user posts request dto param should not be null");
        LOGGER.info("getting user all posts  according to the provided request - {}", dto);
        Optional<User> userOptional = userService.findById(dto.getUserId());

        if (userOptional.isEmpty()) {
            return new GetAllUserPostsResponseDto(List.of(String.format("the user with id %d not found", dto.getUserId())));
        }

        final Optional<List<Post>> optionalPosts = postService.findAllByUserId(dto.getUserId());
        if (optionalPosts.isEmpty()) {
            return new GetAllUserPostsResponseDto(List.of(String.format("the user with id %d still does not have posts ", dto.getUserId())));
        }

        List<Post> posts = optionalPosts.get();
        List<Long> postsId = new LinkedList<>();
        posts.forEach(post -> {
            postsId.add(post.getId());
        });
        List<List<Image>> postsImages = new LinkedList<>();
        posts.forEach(post -> {
            postsImages.add(imageService.findAllByPostId(post.getId()).get());
        });
        List<List<Long>> imagesId = new LinkedList<>();
        postsImages.forEach(images -> {
            List<Long> imageList = new LinkedList<>();
            images.forEach(image -> {
                imageList.add(image.getId());
            });
            imagesId.add(imageList);
        });
         GetAllUserPostsResponseDto responseDto = new GetAllUserPostsResponseDto(dto.getUserId(), postsId,imagesId);
         LOGGER.info(" Successfully got all posts according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}