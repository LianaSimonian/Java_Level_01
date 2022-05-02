package com.aca.classroom.week17.note.service.impl;

import com.aca.classroom.week17.note.entity.Note;
import com.aca.classroom.week17.note.entity.User;
import com.aca.classroom.week17.note.repository.NoteRepository;
import com.aca.classroom.week17.note.service.core.NoteCreationParams;
import com.aca.classroom.week17.note.service.core.NoteService;
import com.aca.classroom.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class NoteServiceImpl implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteServiceImpl.class);

    private final NoteRepository noteRepository;
    private final UserService userService;

    public NoteServiceImpl(NoteRepository noteRepository, UserService userService) {
        Assert.notNull(noteRepository, "note repository cannot be null");
        Assert.notNull(noteRepository, "user service cannot be null");
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    @Override
    public Note create(NoteCreationParams params) {
        Assert.notNull(params, "The provided  params should not be null");
        LOGGER.info("Creating a note for the provided params - {}", params);
        final User user = userService.getById(params.getUserId());
        Note transientNote = new Note(
                params.getText(),
                user,
                params.getCreationDate());
        final Note persistentNote = noteRepository.save(transientNote);
        LOGGER.info("Successfully created a note for the provided params - {}, result -{}", params, persistentNote);
        return persistentNote;
    }
}