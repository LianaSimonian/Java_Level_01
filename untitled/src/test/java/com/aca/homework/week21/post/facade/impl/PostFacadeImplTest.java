package com.aca.homework.week21.post.facade.impl;

import com.aca.homework.week21.post.dto.CreatePostRequestDto;
import com.aca.homework.week21.post.dto.DeletePostResponseDto;
import com.aca.homework.week21.post.dto.PostDto;
import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.mapper.core.PostMapper;
import com.aca.homework.week21.post.service.core.CreatePostParams;
import com.aca.homework.week21.post.service.core.PostService;
import com.aca.homework.week21.post.service.core.RandomFactService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostFacadeImplTest {

    @InjectMocks
    private PostFacadeImpl testSubject;
    @Mock
    private PostService postService;
    @Mock
    private RandomFactService randomFactService;
    @Mock
    private PostMapper postMapper;

    @Test
    public void testCreateWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.create(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("post request dto param should not be null");
    }

    @Test
    public void testCreate() {
        Mockito.when(randomFactService.getRandomFact()).thenReturn("My cat is the best");
        LocalDateTime dateTime = LocalDateTime.of(2020, 04, 01, 12, 30);
        Post post = new Post(dateTime, "My cat is the best", "name");
        Mockito.when(postService.create(new CreatePostParams(dateTime, "My cat is the best", "name"))).thenReturn(post);
        PostDto postDto = new PostDto(dateTime, "My cat is the best", "name");
        Mockito.when(postMapper.map(post)).thenReturn(postDto);
        Assertions.assertThat(testSubject.create(new CreatePostRequestDto("name"))).isEqualTo(postDto);
        verify(postService).create(new CreatePostParams(dateTime, "My cat is the best", "name"));
        verify(postMapper).map(post);
        verify(randomFactService).getRandomFact();
        verifyNoMoreInteractions(postService, postMapper, randomFactService);
    }

    @Test
    public void testGetAllPosts() {
        Post post = new Post(LocalDateTime.of(2020, 02, 02, 01, 30), "post", "name");
        List<Post> posts = List.of(post);
        when(postService.findAll()).thenReturn(posts);
        PostDto postDto = new PostDto(LocalDateTime.of(2020, 02, 02, 01, 30), "post", "name");
        List<PostDto> postDtos = List.of(postDto);
        when(postMapper.map(post)).thenReturn(postDto);
        Assertions.assertThat(testSubject.getAllPosts()).isEqualTo(postDtos);
        verify(postService).findAll();
        verify(postMapper).map(post);
        verifyNoMoreInteractions(postService, postMapper);
    }

    @Test
    public void testGetByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.getById(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("post id should not be null");
    }

    @Test
    public void testGetById() {
        Post post = new Post(LocalDateTime.of(2020, 02, 02, 14, 20), "post", "name");
        when(postService.findById(1L)).thenReturn(Optional.of(post));
        PostDto postDto = new PostDto(LocalDateTime.of(2020, 02, 02, 14, 20), "post", "name");
        when(postMapper.map(post)).thenReturn(postDto);
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(postDto);
        verify(postService).findById(1L);
        verify(postMapper).map(post);
        verifyNoMoreInteractions(postService, postMapper);
    }

    @Test
    public void testGetByIdWhenPostNotFound() {
        Mockito.when(postService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(new PostDto(List.of(String.format("post with id %d not found", 1L))));
        verify(postService).findById(1L);
        verifyNoMoreInteractions(postService);
    }

    @Test
    public void testDeleteByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.deleteById(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("post id should not be null");
    }

    @Test
    public void testDeleteByIdWhenIdNotFound() {
        doThrow(new EmptyResultDataAccessException(1)).when(postService).deleteById(1L);
        Assertions.assertThat(testSubject.deleteById(1L)).isEqualTo(new DeletePostResponseDto(1L, List.of(String.format("post with id %d have not found", 1L))));
        verify(postService).deleteById(1L);
        verifyNoMoreInteractions(postService);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(postService).deleteById(1L);
        Assertions.assertThat(testSubject.deleteById(1L)).isEqualTo(new DeletePostResponseDto(1L, true));
        verify(postService).deleteById(1L);
        verifyNoMoreInteractions(postService);
    }
}