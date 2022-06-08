package com.aca.classroom.week15.user.service.version5;

import com.aca.classroom.week15.user.service.version5.entity.User;
import com.aca.classroom.week15.user.service.version5.facade.UniversityFacade;
import com.aca.classroom.week15.user.service.version5.facade.UserAdmissionRequestDto;
import com.aca.classroom.week15.user.service.version5.facade.UserAdmissionResponseDto;
import com.aca.classroom.week15.user.service.version5.facade.UserGraduationRequestDto;
import com.aca.classroom.week15.user.service.version5.service.core.CreateUserParams;
import com.aca.classroom.week15.user.service.version5.service.core.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@EnableJpaRepositories
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserService userService = context.getBean(UserService.class);

        userService.create(new CreateUserParams("username",
                "firsName",
                "secondName",
                LocalDate.now(),
                "password"));
        final PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        System.out.println(passwordEncoder);

/*
        if( true){
            return;
        }

 */
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

        // System.out.println(universityFacade.graduate(new UserGraduationRequestDto("abc")));
        User user = userService.getByUsername("username");
        System.out.println("The user is " + user);


    }

    //debug
    //proxi design pattern
//control p
}
//dependency injection
//state full/less
//dpenedency
//state
//proxi sarquma Spring@ framework@
//lazy roll ? eta
//transaction pti nunenanq cankacath queriy ashxatcnelus
// begin transaction; query ;commit ;
//lazy singlton