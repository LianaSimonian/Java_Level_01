package com.aca.classroom.week15.user.service.version5.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(Main.class, args);
        Repository1 bean = context.getBean(Repository1.class);
        bean.deleteAll();
        Printer printer1 = context.getBean(Printer1.class);
        Printer printer2 = (Printer) context.getBean("defaultPrinter");
        printer1.print();
    }

    @Bean
    @Scope(value = "prototype") // everytime returns a new repository
    public Repository1 repository1() {
        return new Repository1();
    }
}
//repository1 glxin component 2 tarberak
