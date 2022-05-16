package com.aca.homework.week18.website.facade.post.impl;

import com.aca.homework.week18.website.entity.Post;
import com.aca.homework.week18.website.facade.post.core.PostCreationResponseDto;
import com.aca.homework.week18.website.facade.post.core.PostMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class PostMapperImpl implements PostMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostMapperImpl.class);


    @Override
    public PostCreationResponseDto mapper(Post post) {
        final List<Long> imageBlobIds = post.getImageBlobIds();
        LOGGER.info("Mapping a post - {} with images {} to post creation response dto", post, imageBlobIds);
        PostCreationResponseDto responseDto = new PostCreationResponseDto(post.getId(), post.getTitle(), post.getDescription(), post.getUser().getId(), imageBlobIds, LocalDate.now());
        LOGGER.info("Successfully mapped a post - {} with images {} to post creation Response dto ,result - {}", post, imageBlobIds, responseDto);
        return responseDto;
    }
}