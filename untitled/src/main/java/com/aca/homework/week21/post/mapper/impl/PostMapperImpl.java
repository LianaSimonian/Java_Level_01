package com.aca.homework.week21.post.mapper.impl;

import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.mapper.core.PostMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PostMapperImpl implements PostMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostMapperImpl.class);

    @Override
    public PostDto map(Post post) {
        Assert.notNull(post, "the post param cannot be null");
        LOGGER.info("Mapping a post - {} to post dto", post);
        final PostDto postDto = new PostDto(post.getCreationDate(), post.getContent(), post.getCreatedBy());
        LOGGER.info("Successfully mapped a post - {} to post dto ,result - {}", post, postDto);
        return postDto;
    }
}