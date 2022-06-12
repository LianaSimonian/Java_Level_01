package com.aca.homework.week21.post.facade.impl;

import com.aca.homework.week21.post.dto.CreatePostsRequestDto;
import com.aca.homework.week21.post.dto.CreatePostsResponseDto;
import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.mapper.core.PostMapper;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    private PostFacadeImpl testSubject;
    @Mock
    private PostService postService;
    @Mock
    private RandomFactService randomFactService;
    @Mock
    private PostMapper postMapper;

    @BeforeEach
    public void init() {
        testSubject = new PostFacadeImpl(postService, randomFactService, postMapper, "bulk@");
    }

    @Test
    public void testCreatePostsWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.createPosts(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the posts request dto param should not be null");
    }

    @Test
    public void testCreatePosts() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 02, 02, 01, 01);
        Post post = new Post(dateTime, "bulk@content", "name");
        Mockito.when(postService.create(new CreatePostParams(dateTime, "bulk@content", "name"))).thenReturn(post);
        Mockito.when(randomFactService.getRandomFact()).thenReturn("content");
        PostDto postDto = new PostDto(dateTime, "bulk@content", "name");
        Mockito.when(postMapper.map(post)).thenReturn(postDto);
        Assertions.assertThat(testSubject.createPosts(new CreatePostsRequestDto("name", 1))).isEqualTo(new CreatePostsResponseDto(List.of(postDto)));
        verify(postService).create(new CreatePostParams(dateTime, "bulk@content", "name"));
        verify(randomFactService).getRandomFact();
        verify(postMapper).map(post);
        verifyNoMoreInteractions(postService, randomFactService, postMapper);
    }
}