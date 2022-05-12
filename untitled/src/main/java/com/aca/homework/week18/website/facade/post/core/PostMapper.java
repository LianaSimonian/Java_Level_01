package com.aca.homework.week18.website.facade.post.core;

import com.aca.homework.week18.website.entity.Post;

import java.util.List;

public interface PostMapper {

    PostCreationResponseDto mapper(Post post, List<Long> images);
}
