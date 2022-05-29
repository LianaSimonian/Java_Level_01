package com.aca.classroom.week15.user.service.version5.service.impl;

import com.aca.classroom.week15.user.service.version5.entity.User;
import com.aca.classroom.week15.user.service.version5.repository.UserRepository;
import com.aca.classroom.week15.user.service.version5.service.core.UserService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    public void testCheckCredentialsWhenUserNotFound() {
        Mockito.when(userRepository.findByUsername("javalvl1")).thenReturn(Optional.empty());
        boolean result = userService.checkCredentials("javalvl1", "prof_froup");
        Assertions.assertThat(result).isFalse();

        Mockito.verify(userRepository).findByUsername("javalvl1");
        Mockito.verifyNoMoreInteractions(userRepository, passwordEncoder);
    }

    @Test
    public void testCheckCredentialsWhenPasswordIsWrong() {
        User user = new User();
        user.setPassword("%gfrdhj");
        Mockito.when(userRepository.findByUsername("javalvl1")).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.matches("prof-group", "%gfrdhj")).thenReturn(false);
        boolean result = userService.checkCredentials("javalvl1", "prof-group");
        Assertions.assertThat(result).isFalse();
        Mockito.verify(userRepository).findByUsername("javalvl1");
        Mockito.verify(passwordEncoder).matches("prof-group", "%gfrdhj");
        Mockito.verifyNoMoreInteractions(userRepository, passwordEncoder);
    }

    @Test
    public void testCheckCredentialsWhenPasswordIsCorrect() {
        User user = new User();
        user.setPassword("%gfrdhj");
        Mockito.when(userRepository.findByUsername("javalvl1")).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.matches("prof-group", "%gfrdhj")).thenReturn(true);
        boolean result = userService.checkCredentials("javalvl1", "prof-group");
        Assertions.assertThat(result).isTrue();
        Mockito.verify(userRepository).findByUsername("javalvl1");
        Mockito.verify(passwordEncoder).matches("prof-group", "%gfrdhj");
        Mockito.verifyNoMoreInteractions(userRepository, passwordEncoder);
    }
}