package com.aca.homework.week17.note;

import com.aca.homework.week17.note.facade.note.NoteCreationRequestDto;
import com.aca.homework.week17.note.facade.note.NoteFacade;
import com.aca.homework.week17.note.facade.note.NoteFacadeImpl;
import com.aca.homework.week17.note.facade.user.UserFacade;
import com.aca.homework.week17.note.facade.user.UserFacadeImpl;
import com.aca.homework.week17.note.facade.user.UserSignUpRequestDto;
import com.aca.homework.week17.note.repository.NoteRepository;
import com.aca.homework.week17.note.repository.UserRepository;
import com.aca.homework.week17.note.service.core.NoteService;
import com.aca.homework.week17.note.service.core.UserService;
import com.aca.homework.week17.note.service.impl.NoteServiceImpl;
import com.aca.homework.week17.note.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Main {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        NoteRepository noteRepository = context.getBean(NoteRepository.class);

        UserService userService = new UserServiceImpl(userRepository);
        NoteService noteService = new NoteServiceImpl(noteRepository, userService);

        UserFacade userFacade = new UserFacadeImpl(userService);
        NoteFacade noteFacade = new NoteFacadeImpl(noteService, userService);

        userFacade.signUp(new UserSignUpRequestDto("username1", "firstname1", "secondname1"));

        userFacade.signUp(new UserSignUpRequestDto("username2", "firstname2", "secondName2"));

        noteFacade.create(new NoteCreationRequestDto("username1", "note1"));

        noteFacade.create(new NoteCreationRequestDto("username2", "text1"));

        noteFacade.create(new NoteCreationRequestDto("username1", "note2"));

        noteFacade.create(new NoteCreationRequestDto("username2", "text2"));
    }
}