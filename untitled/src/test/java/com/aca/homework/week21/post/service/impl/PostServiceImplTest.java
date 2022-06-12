package com.aca.homework.week21.post.service.impl;

import com.aca.homework.week21.post.entity.Post;
import com.aca.homework.week21.post.repository.PostRepository;

import com.aca.homework.week21.post.service.core.CreatePostParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
    @InjectMocks
    private PostServiceImpl testSubject;

    @Mock
    private PostRepository postRepository;

    @Test
    public void testCreateWhenParamIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.create(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("The provided  params should not be null");
    }

    @Test
    public void testCreate() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 04, 01, 12, 30);
        Post post = new Post(dateTime, "my cat is the best", "user1");
        Mockito.when(postRepository.save(post)).thenReturn(post);
        Assertions.assertThat(testSubject.create(new CreatePostParams(dateTime, "my cat is the best", "user1"))).isEqualTo(post);
        verify(postRepository).save(post);
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testFindAll() {
        Mockito.when(postRepository.findAll()).thenReturn(List.of());
        Assertions.assertThat(testSubject.findAll()).isEqualTo(List.of());
        verify(postRepository).findAll();
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testFindByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.findById(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("post id should not be null");
    }

    @Test
    public void testFindById() {
        Optional<Post> postOptional = Optional.of(new Post(LocalDateTime.now(), "My cat is the best", "name"));
        Mockito.when(postRepository.findById(1L)).thenReturn(postOptional);
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(postOptional);
        verify(postRepository).findById(1L);
        verifyNoMoreInteractions(postRepository);
    }

    @Test
    public void testDeleteByIdWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.deleteById(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("post id should not be null");
    }

    @Test
    public void testDeleteById() {
        doNothing().when(postRepository).deleteById(1L);
        testSubject.deleteById(1L);
        verify(postRepository, times(1)).deleteById(1L);
        verifyNoMoreInteractions(postRepository);

    }
}