package com.aca.homework.week21.post.mapper.core;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;

public interface PostMapper {

    PostDto map(Post post);
}
