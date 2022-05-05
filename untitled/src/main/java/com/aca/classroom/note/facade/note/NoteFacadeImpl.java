package com.aca.classroom.note.facade.note;

import com.aca.classroom.note.entity.Note;
import com.aca.classroom.note.entity.User;
import com.aca.classroom.note.service.core.NoteCreationParams;
import com.aca.classroom.note.service.core.NoteService;
import com.aca.classroom.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class NoteFacadeImpl implements NoteFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteFacadeImpl.class);

    private final NoteService noteService;
    private final UserService userService;

    public NoteFacadeImpl(NoteService noteService, UserService userService) {
        Assert.notNull(noteService, "The provided noteService should not be null");
        Assert.notNull(userService, "The provided userService should not be null");
        this.noteService = noteService;
        this.userService = userService;
    }

    @Override
    public NoteCreationResponseDto create(NoteCreationRequestDto dto) {
        Assert.notNull(dto, "note creation request dto param should not be null");
        LOGGER.info("creating the note  according to the provided request - {}", dto);
        User user = userService.getByUsername(dto.getUsername());
        final Note note = noteService.create(new NoteCreationParams(
                dto.getText(),
                user.getId(),
                LocalDate.now()
        ));
        NoteCreationResponseDto responseDto = new NoteCreationResponseDto(note.getUser().getUsername(), note.getText(), note.getCreationDate());
        LOGGER.info(" Successfully created note  according to the provided request - {}, responseDto - {}", dto, responseDto);
        return responseDto;
    }
}
