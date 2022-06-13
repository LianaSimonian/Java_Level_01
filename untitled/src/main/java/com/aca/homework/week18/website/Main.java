package com.aca.homework.week18.website;

import com.aca.homework.week18.website.facade.post.core.*;
import com.aca.homework.week18.website.facade.post.impl.ImageMapperImpl;
import com.aca.homework.week18.website.facade.post.impl.PostFacadeImpl;
import com.aca.homework.week18.website.facade.post.impl.PostMapperImpl;
import com.aca.homework.week18.website.facade.user.core.UserFacade;
import com.aca.homework.week18.website.facade.user.core.UserMapper;
import com.aca.homework.week18.website.facade.user.impl.UserFacadeImpl;
import com.aca.homework.week18.website.facade.user.impl.UserMapperImpl;
import com.aca.homework.week18.website.facade.user.core.UserSignUpRequestDto;
import com.aca.homework.week18.website.repository.ImageRepository;
import com.aca.homework.week18.website.repository.PostRepository;
import com.aca.homework.week18.website.repository.UserRepository;
import com.aca.homework.week18.website.service.core.ImageService;
import com.aca.homework.week18.website.service.core.PostService;
import com.aca.homework.week18.website.service.core.UserService;
import com.aca.homework.week18.website.service.impl.ImageServiceImpl;
import com.aca.homework.week18.website.service.impl.PostServiceImpl;
import com.aca.homework.week18.website.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        PostRepository postRepository = context.getBean(PostRepository.class);
        ImageRepository imageRepository = context.getBean(ImageRepository.class);

        UserService userService = new UserServiceImpl(userRepository);
        PostService postService = new PostServiceImpl(postRepository, userService);
        ImageService imageService = new ImageServiceImpl(imageRepository, postService);
        UserMapper userMapper = new UserMapperImpl();
        ImageMapper imageMapper = new ImageMapperImpl();
        PostMapper postMapper = new PostMapperImpl();

        UserFacade userFacade = new UserFacadeImpl(userService, userMapper);
        userFacade.signUp(new UserSignUpRequestDto("name1", "surname1", "lia456", "12ABC45"));
        userFacade.signUp(new UserSignUpRequestDto("name2", "surname2", "lia45556", "12ABC745"));
        userFacade.signUp(new UserSignUpRequestDto("name3", "surname3", "lia4586", "1BC45"));
        userFacade.signUp(new UserSignUpRequestDto("name4", "surname4", "lia45688", "178ABC45"));

        PostFacade postFacade = new PostFacadeImpl(
                postService,
                userService,
                imageService,
                imageMapper,
                postMapper,
                userMapper);

        postFacade.create(new PostCreationRequestDto("title1", "description1", 1L, List.of(1245L, 4545L, 4145L, 45787L)));
        postFacade.create(new PostCreationRequestDto("title1", "description1", 2L, List.of(1245L, 4545L, 4145L, 45787L)));
        postFacade.create(new PostCreationRequestDto("title1", "description1", 3L, List.of(1245L, 4545L, 4145L, 45787L)));
        postFacade.create(new PostCreationRequestDto("title1", "description1", 4L, List.of(1245L, 4545L, 4145L, 45787L)));
        System.out.println("################");
        System.out.println(postFacade.create(new PostCreationRequestDto("title1", "description1", 5L, List.of(1245L, 4545L, 4145L, 45787L))));

        postFacade.getAllUserPosts(new GetAllUserPostsRequestDto(1L));
    }
}