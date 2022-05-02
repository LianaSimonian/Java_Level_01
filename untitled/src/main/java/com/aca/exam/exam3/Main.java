package com.aca.exam.exam3;

import com.aca.classroom.week15.user.service.version2.CreateUserParams;
import com.aca.exam.exam3.facade.PlateNumberRequestDto;
import com.aca.exam.exam3.facade.UserPlateNumberFacade;
import com.aca.exam.exam3.facade.UserPlateNumberFacadeImpl;
import com.aca.exam.exam3.repository.PlateNumberRepository;
import com.aca.exam.exam3.repository.UserRepository;
import com.aca.exam.exam3.service.core.UserPlateNumberService;
import com.aca.exam.exam3.service.core.UserService;
import com.aca.exam.exam3.service.impl.UserPlateNumberServiceImpl;
import com.aca.exam.exam3.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        PlateNumberRepository plateNumberRepository = context.getBean(PlateNumberRepository.class);

        UserService userService = new UserServiceImpl(userRepository);
        UserPlateNumberService plateNumberService = new UserPlateNumberServiceImpl(plateNumberRepository, userService);

        UserPlateNumberFacade userPlateNumberFacade = new UserPlateNumberFacadeImpl(plateNumberService, userService);

        userPlateNumberFacade.create(new PlateNumberRequestDto(1L));
        userPlateNumberFacade.create(new PlateNumberRequestDto(2L));
        userPlateNumberFacade.create(new PlateNumberRequestDto(3L));
        userPlateNumberFacade.create(new PlateNumberRequestDto(4L));
        userPlateNumberFacade.create(new PlateNumberRequestDto(5L));
    }
}