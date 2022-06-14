package com.aca.homework.week19.job.platform.facade.impl;

import com.aca.homework.week19.job.platform.dto.UserDetailsDto;
import com.aca.homework.week19.job.platform.dto.UserSignUpRequestDto;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.mapper.core.UserMapper;
import com.aca.homework.week19.job.platform.service.core.CreateUserParams;
import com.aca.homework.week19.job.platform.service.core.UpdateUserParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserFacadeImplTest {

    @InjectMocks
    private UserFacadeImpl testSubject;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Test
    public void testSignUpWhenDtoIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.signUp(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the user signUp request dto param should not be null");
    }

    @Test
    public void testSignUpWhenUserAlreadyExists() {
        User user = new User("firstName", "secondName", "username", "password", true);
        Mockito.when(userService.findByUsernameAndPassword("username", "password")).thenReturn(Optional.of(user));
        Assertions.assertThat(testSubject.signUp(new UserSignUpRequestDto("firstName", "secondName", "username", "password"))).isEqualTo(new UserDetailsDto(List.of(String.format("user with username %s and password %s already exists", "username", "password"))));
        verify(userService).findByUsernameAndPassword("username", "password");
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testSignUp() {
        Mockito.when(userService.findByUsernameAndPassword("username", "password")).thenReturn(Optional.empty());
        User user = new User("firstName", "secondName", "username", "password", false);
        Mockito.when(userService.create(new CreateUserParams("firstName", "secondName", "username", "password", false))).thenReturn(user);
        UserDetailsDto userDetailsDto = new UserDetailsDto("firstName", "secondName", "username", "password", false);
        Mockito.when(userMapper.mapper(user)).thenReturn(userDetailsDto);
        Assertions.assertThat(testSubject.signUp(new UserSignUpRequestDto("firstName", "secondName", "username", "password"))).isEqualTo(userDetailsDto);
        verify(userService).findByUsernameAndPassword("username", "password");
        verify(userService).create(new CreateUserParams("firstName", "secondName", "username", "password", false));
        verify(userMapper).mapper(user);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testGetUserDetailsWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.getUserDetails(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the userId cannot be null");
    }

    @Test
    public void testGetUserDetailsWhenUserNotFound() {
        when(userService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.getUserDetails(1L)).isEqualTo(new UserDetailsDto(List.of(String.format("user with id %d not found", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserDetails() {
        User user = new User("firstName", "secondName", "username", "password", false);
        when(userService.findById(1L)).thenReturn(Optional.of(user));
        UserDetailsDto userDetailsDto = new UserDetailsDto("firstName", "secondName", "username", "password", false);
        when((userMapper.mapper(user))).thenReturn(userDetailsDto);
        Assertions.assertThat(testSubject.getUserDetails(1L)).isEqualTo(userDetailsDto);
        verify(userService).findById(1L);
        verify(userMapper).mapper(user);
        verifyNoMoreInteractions(userService, userMapper);
    }

    @Test
    public void testOpenToWorkWhenIdIsNull() {
        Assertions.assertThatThrownBy(() -> testSubject.openToWork(null)).isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("the userId cannot be null");
    }

    @Test
    public void testOpenToWorkWhenUserNotFound() {
        when(userService.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.openToWork(1L)).isEqualTo(new UserDetailsDto(List.of(String.format("user with id %d not found", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testOpenToWorkWhenUserAlreadyIsOpenForJobOffers() {
        User user = new User("firstName", "secondName", "username", "password", true);
        when(userService.findById(1L)).thenReturn(Optional.of(user));
        Assertions.assertThat(testSubject.openToWork(1L)).isEqualTo(new UserDetailsDto(List.of(String.format("user with id %d already is open for job offers", 1L))));
        verify(userService).findById(1L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testOpenForJobOffers() {
        User user = new User("firstName", "secondName", "username", "password", false);
        user.setId(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));
        User updatedUser = new User("firstName", "secondName", "username", "password", true);
        updatedUser.setId(1L);
        when(userService.update(new UpdateUserParams(1L, "username", "password", true))).thenReturn(updatedUser);
        UserDetailsDto userDetailsDto = new UserDetailsDto("firstName", "secondName", "username", "password", true);
        when(userMapper.mapper(updatedUser)).thenReturn(userDetailsDto);
        Assertions.assertThat(testSubject.openToWork(1L)).isEqualTo(userDetailsDto);
        verify(userService).findById(1L);
        verify(userService).update(new UpdateUserParams(1L, "username", "password", true));
        verify(userMapper).mapper(updatedUser);
        verifyNoMoreInteractions(userService, userMapper);
    }
}