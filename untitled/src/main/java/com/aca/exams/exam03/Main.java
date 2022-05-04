package com.aca.exams.exam03;

import com.aca.exams.exam03.repository.PlateNumberRepository;
import com.aca.exams.exam03.repository.UserPlateNumberRepository;
import com.aca.exams.exam03.repository.UserRepository;
import com.aca.exams.exam03.service.core.PlateNumberService;
import com.aca.exams.exam03.service.core.UserCreationParams;
import com.aca.exams.exam03.service.core.UserPlateNumberService;
import com.aca.exams.exam03.service.core.UserService;
import com.aca.exams.exam03.service.impl.PlateNumberServiceImpl;
import com.aca.exams.exam03.service.impl.UserPlateNumberServiceImpl;
import com.aca.exams.exam03.service.impl.UserServiceImpl;
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
        UserPlateNumberRepository userPlateNumberRepository = context.getBean(UserPlateNumberRepository.class);


        UserService userService = new UserServiceImpl(userRepository);
        PlateNumberService plateNumberService = new PlateNumberServiceImpl(plateNumberRepository);
        UserPlateNumberService userPlateNumberService = new UserPlateNumberServiceImpl(userPlateNumberRepository, userService, plateNumberService);

        userService.create(new UserCreationParams("01ABC", "Lia", "Adamian"));
        userService.create(new UserCreationParams("01ABD", "Karen", "Adamian"));
        userService.create(new UserCreationParams("01ABE", "Roza", "Tunian"));
        userService.create(new UserCreationParams("01ABK", "Abel", "Nersesian"));

    }
}