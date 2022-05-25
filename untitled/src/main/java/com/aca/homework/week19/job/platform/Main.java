package com.aca.homework.week19.job.platform;

import com.aca.homework.week19.job.platform.dto.*;
import com.aca.homework.week19.job.platform.facade.core.*;
import com.aca.homework.week19.job.platform.facade.impl.InvitationFacadeImpl;
import com.aca.homework.week19.job.platform.facade.impl.JobFacadeImpl;
import com.aca.homework.week19.job.platform.facade.impl.OrganizationFacadeImpl;
import com.aca.homework.week19.job.platform.facade.impl.UserFacadeImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories
public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        final UserFacade userFacade = context.getBean(UserFacadeImpl.class);
        userFacade.signUp(new UserSignUpRequestDto("Lusy", "Grigorian", "lusigrig", "11199AM"));
        userFacade.signUp(new UserSignUpRequestDto("Arsen", "Matinian", "arsenmat", "111244Am"));
        System.out.println();
        System.out.println(userFacade.getUserDetails(1L));
        System.out.println(userFacade.getUserDetails(2l));
        userFacade.openToWork(1L);
        userFacade.openToWork(2L);

        OrganizationFacade organizationFacade = context.getBean(OrganizationFacadeImpl.class);
        organizationFacade.register(new OrganizationRegistrationRequestDto("Mentor Graphics", LocalDate.of(2010, 01, 01)));
        organizationFacade.register(new OrganizationRegistrationRequestDto("Krisp", LocalDate.of(2017, 01, 01)));
        System.out.println();
        System.out.println(organizationFacade.getOrganizationDetails(1L));
        System.out.println(organizationFacade.getOrganizationDetails(2L));


        InvitationFacade invitationFacade = context.getBean(InvitationFacadeImpl.class);
        invitationFacade.sendInvitation(new InvitationRequestDto(1L, 1L));
        invitationFacade.acceptInvitation(new InvitationAcceptDto(1L, 1L));
        invitationFacade.sendInvitation(new InvitationRequestDto(2L, 1L));
        invitationFacade.rejectInvitation(new InvitationRejectDto(2L, 2L));

        JobFacade jobFacade = context.getBean(JobFacadeImpl.class);
        jobFacade.hire(new JobHireRequestDto(1L, 1L));
    }
}