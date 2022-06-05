package com.aca.homework.week21.post;

import com.aca.homework.week21.post.dto.CreatePostRequestDto;
import com.aca.homework.week21.post.facade.core.PostFacade;
import com.aca.homework.week21.post.facade.impl.PostFacadeImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        PostFacade postFacade = context.getBean(PostFacadeImpl.class);
        postFacade.create(new CreatePostRequestDto("name"));
        System.out.println("###########");
        System.out.println(postFacade.getById(1L));
        postFacade.deleteById(1L);
        System.out.println("@@@@@@@@@@@@@@");
        System.out.println(postFacade.getAllPosts());
    }
}
