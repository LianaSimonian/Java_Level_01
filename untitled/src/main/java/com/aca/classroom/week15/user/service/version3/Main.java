package com.aca.classroom.week15.user.service.version3;

import com.aca.classroom.week15.user.service.version3.entity.Diploma;
import com.aca.classroom.week15.user.service.version3.entity.DiplomaColorType;
import com.aca.classroom.week15.user.service.version3.entity.User;
import com.aca.classroom.week15.user.service.version3.facade.UniversityFacade;
import com.aca.classroom.week15.user.service.version3.facade.UniversityFacadeImpl;
import com.aca.classroom.week15.user.service.version3.repository.DiplomaRepository;
import com.aca.classroom.week15.user.service.version3.repository.UserRepository;
import com.aca.classroom.week15.user.service.version3.service.core.CreateDiplomaParams;
import com.aca.classroom.week15.user.service.version3.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version3.service.core.DiplomaService;
import com.aca.classroom.week15.user.service.version3.service.core.UserService;
import com.aca.classroom.week15.user.service.version3.service.impl.DipolmaServiceImpl;
import com.aca.classroom.week15.user.service.version3.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        DiplomaRepository diplomaRepository = context.getBean(DiplomaRepository.class);

        UniversityFacade universityFacade = new UniversityFacadeImpl(new UserServiceImpl(userRepository),
                new DipolmaServiceImpl(diplomaRepository, new UserServiceImpl(userRepository)));

        UserService userService = new UserServiceImpl(userRepository);
        DiplomaService diplomaService = new DipolmaServiceImpl(diplomaRepository, new UserServiceImpl(userRepository));
        User user = userService.create(new CreateUserParams("arm", "Arm", "Simonian"));

        final Diploma diploma = diplomaService.create(
                new CreateDiplomaParams(DiplomaColorType.RED,
                        LocalDate.of(2018, 9, 3),
                        LocalDate.of(2022, 4, 5),
                        user.getId()
                )
        );
        /*


        final User transientUser  =new User("aca","ACA","academy");
        final User persistentUser= userRepository.save(transientUser);

        diplomaRepository.save(new Diploma(DiplomaColorType.RED, LocalDate.of(2018,9,1),LocalDate.of(2022,4,28),persistentUser));

         */
/*
        // User user = new User("Username", "First Name", "Secondname");

        // userRepository.save(user);

        UserService userService = new UserServiceImpl(userRepository);
        for (int i = 0; i < 100; i++) {
            userService.create(new CreateUserParams(
                    "username" + i,
                    "first " + i,
                    "second " + i));
        }

        System.out.println(userService.getByUsername("username90"));

 */
    }
//control p
}
