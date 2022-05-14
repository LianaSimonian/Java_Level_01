package com.aca.classroom.week15.user.service.version4;

import com.aca.classroom.week15.user.service.version4.facade.*;
import com.aca.classroom.week15.user.service.version4.repository.DiplomaRepository;
import com.aca.classroom.week15.user.service.version4.repository.UserRepository;
import com.aca.classroom.week15.user.service.version4.service.core.UserService;
import com.aca.classroom.week15.user.service.version4.service.impl.DipolmaServiceImpl;
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
        /*
        UserRepository userRepository = context.getBean(UserRepository.class);
        UserMapper mapper = context.getBean(UserMapper.class);
        System.out.println("hashcode = " +mapper.hashCode());
        UserService userService = context.getBean(UserService.class);

         */
          UniversityFacade universityFacade = context.getBean(UniversityFacade.class);

        UserAdmissionResponseDto name1Response = universityFacade.admit(new UserAdmissionRequestDto("Liana", "Simonian"));
        UserAdmissionResponseDto name2Response = universityFacade.admit(new UserAdmissionRequestDto("Diana", "Simonian"));
        UserAdmissionResponseDto name3Response = universityFacade.admit(new UserAdmissionRequestDto("Arsen", "Simonian"));
        UserAdmissionResponseDto name4Response = universityFacade.admit(new UserAdmissionRequestDto("Olya", "Ayvazian"));

        universityFacade.graduate(new UserGraduationRequestDto(name1Response.getUsername()));
        universityFacade.graduate(new UserGraduationRequestDto("Diana_Simonian"));
        System.out.println(universityFacade.graduate(new UserGraduationRequestDto("abc")));

    }
//control p
}
//dependency injection
//state full/less
//dpenedency
//state
//proxi sarquma Spring@ framework@