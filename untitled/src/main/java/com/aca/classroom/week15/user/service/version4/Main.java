package com.aca.classroom.week15.user.service.version4;

import com.aca.classroom.week15.user.service.version4.facade.*;
import com.aca.classroom.week15.user.service.version4.repository.DiplomaRepository;
import com.aca.classroom.week15.user.service.version4.repository.UserRepository;
import com.aca.classroom.week15.user.service.version4.service.core.UserService;
import com.aca.classroom.week15.user.service.version4.service.impl.DiplomaServiceImpl;
import com.aca.classroom.week15.user.service.version4.service.impl.UserServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        DiplomaRepository diplomaRepository = context.getBean(DiplomaRepository.class);

        UserServiceImpl userService1 = new UserServiceImpl(userRepository);
        UniversityFacade universityFacade = new UniversityFacadeImpl(userService1,
                new DiplomaServiceImpl(diplomaRepository, userService1), new UserMapperImpl());
        UserService userService = new UserServiceImpl(userRepository);
        UserAdmissionResponseDto name1Response = universityFacade.admit(new UserAdmissionRequestDto("Liana", "Simonian"));
        UserAdmissionResponseDto name2Response = universityFacade.admit(new UserAdmissionRequestDto("Diana", "Simonian"));
        UserAdmissionResponseDto name3Response = universityFacade.admit(new UserAdmissionRequestDto("Arsen", "Simonian"));
        UserAdmissionResponseDto name4Response = universityFacade.admit(new UserAdmissionRequestDto("Olya", "Ayvazian"));

        universityFacade.graduate(new UserGraduationRequestDto(name1Response.getUsername()));
        universityFacade.graduate(new UserGraduationRequestDto("Diana"));
        universityFacade.graduate(new UserGraduationRequestDto("abc"));

          /*
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
       never do that without Service(UserService,DiplomaService),
        final User transientUser  =new User("aca","ACA","academy");
        final User persistentUser= userRepository.save(transientUser);
        diplomaRepository.save(new Diploma(DiplomaColorType.RED, LocalDate.of(2018,9,1),LocalDate.of(2022,4,28),persistentUser));
         */

/*      this is a bed strategy
         User user = new User("Username", "First Name", "Secondname");
          userRepository.save(user);
*/
        /* right strategy is this
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
