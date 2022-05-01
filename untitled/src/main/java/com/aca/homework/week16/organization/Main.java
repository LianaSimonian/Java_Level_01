package com.aca.homework.week16.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);

        OrganizationService organizationService = new OrganizationServiceImpl(organizationRepository);
        for (int i = 0; i < 100; i++) {
            organizationService.create(new OrganizationCreateParams(
                    "name" + i,
                    "address " + i));
        }

        System.out.println(organizationService.getById(20L));
    }
}
