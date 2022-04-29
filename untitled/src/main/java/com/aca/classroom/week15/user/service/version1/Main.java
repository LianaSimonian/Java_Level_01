package com.aca.classroom.week15.user.service.version1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        final UserRepository userRepository = context.getBean(UserRepository.class);

        UserService userService = new UserServiceImpl(userRepository);

        for (int i = 0; i < 100; i++) {
            userService.create(new CreateUserParams("first " + i, "second " + i));
        }
    }
}