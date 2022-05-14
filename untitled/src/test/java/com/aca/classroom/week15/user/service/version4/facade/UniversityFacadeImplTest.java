package com.aca.classroom.week15.user.service.version4.facade;


import com.aca.classroom.week15.user.service.version04.entity.User;
import com.aca.classroom.week15.user.service.version04.facade.*;
import com.aca.classroom.week15.user.service.version04.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version04.service.core.DiplomaService;
import com.aca.classroom.week15.user.service.version04.service.core.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class UniversityFacadeImplTest {

    private UniversityFacade universityFacade;
    @Mock
    private UserService userService;
    @Mock
    private DiplomaService diplomaService;
    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        universityFacade = new UniversityFacadeImpl(userService, diplomaService, userMapper);
    }

    @Test
    public void testAdmit() {
        Mockito.when(userService.create(new CreateUserParams("Armen_Grigoryan", "Armen", "Grigoryan", LocalDate.now()))).thenReturn(new User());
        final UserAdmissionResponseDto response = universityFacade.admit(new UserAdmissionRequestDto("Armen", "Grigoryan"));
    }
}
