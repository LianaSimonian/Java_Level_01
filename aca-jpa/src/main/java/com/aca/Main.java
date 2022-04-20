package com.aca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        /*
        UserRepository userRepository=null;
        userRepository.save(new User());

         */
        //  User user = userRepository.getById(1L);
        //  userRepository.delete(user);

        UserRepository userRepository = context.getBean(UserRepository.class);
        /*
        System.out.println();
        User user = new User();
        user.setId(1L);
        user.setFirstName("user name");
        user.setSecondName("Second1 Name");
        userRepository.save(user);


         */

        UserService userService = new UserServiceImpl(userRepository);
        for (int i = 0; i < 100; i++) {
            userService.create(new CreateUserParams("first" + i, "second" + i));
        }
    }
}
