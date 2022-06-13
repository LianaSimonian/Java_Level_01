package com.aca.homework.week18.website.facade.post.impl;

import com.aca.homework.week18.website.entity.Image;
import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.entity.User;
import com.aca.homework.week18.website.facade.post.core.*;
import com.aca.homework.week18.website.facade.user.core.UserMapper;
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
    private final UserMapper userMapper;

    public PostFacadeImpl(PostService postService, UserService userService, ImageService imageService, ImageMapper imageMapper, PostMapper postMapper, UserMapper userMapper) {
        Assert.notNull(postService, "The provided postService should not be null");
        Assert.notNull(userService, "The provided userService should not be null");
        Assert.notNull(imageService, "The provided imageService should not be null");
        Assert.notNull(imageMapper, "The provided imageMapper should not be null");
        Assert.notNull(postMapper, "The provided postMapper should not be null");
        Assert.notNull(userMapper, "The provided userMapper should not be null");
        this.postService = postService;
        this.userService = userService;
        this.imageService = imageService;
        this.imageMapper = imageMapper;
        this.postMapper = postMapper;
        this.userMapper = userMapper;
    }

    @Override
    public PostCreationResponseDto create(PostCreationRequestDto dto) {
        Assert.notNull(dto, "post creation request dto param should not be null");
        LOGGER.info("creating the post  according to the provided request - {}", dto);
        List<Long> imageBlobIds = dto.getImagesBlobId();

        if (imageBlobIds.size() > 5) {
            return new PostCreationResponseDto(List.of(String.format("the number %d of uploaded images can not be greater than %d ", imageBlobIds.size(), 5)));
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
                        userId,
                        LocalDate.now()
                )
        );
        post.setImageBlobIds(imageBlobIds);
        imageBlobIds.forEach(image -> {
            uploadImage(new UploadImageRequestDto(image, post.getId()));
        });
        PostCreationResponseDto responseDto = postMapper.mapper(post);
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
        final Optional<User> userOptional = userService.findById(dto.getUserId());

        if (userOptional.isEmpty()) {
            return new GetAllUserPostsResponseDto(List.of(String.format("the user with id %d not found", dto.getUserId())));
        }

        final List<Post> posts = postService.findAllByUserId(dto.getUserId());
        if (posts.isEmpty()) {
            return new GetAllUserPostsResponseDto(List.of(String.format("the user with id %d still does not have posts ", dto.getUserId())));
        }

        List<PostCreationResponseDto> postsDto = new LinkedList<>();

        posts.forEach(post -> {
            List<Long> blobIds = new LinkedList<>();
            List<Image> images = imageService.findAllByPostId(post.getId());
            images.forEach(image -> blobIds.add(image.getBlobId()));
            postsDto.add(new PostCreationResponseDto(post.getId(), post.getTitle(), post.getDescription(), post.getUser().getId(), blobIds, post.getPostCreationDate()));
        });
        User user = userOptional.get();
        GetAllUserPostsResponseDto responseDto = new GetAllUserPostsResponseDto(
                userMapper.mapper(user),
                postsDto);
        LOGGER.info(" Successfully got all posts according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}