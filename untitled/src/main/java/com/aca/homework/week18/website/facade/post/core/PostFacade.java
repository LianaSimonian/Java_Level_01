package com.aca.homework.week18.website.facade.post.core;


public interface PostFacade {

    PostCreationResponseDto create(PostCreationRequestDto dto);

    UploadImageResponseDto uploadImage(UploadImageRequestDto dto);

    GetAllUserPostsResponseDto getAllUserPosts(GetAllUserPostsRequestDto dto);
}