package com.aca.classroom.week17.note.service.core;


import com.aca.classroom.week17.note.entity.Note;

public interface NoteService {

    Note create(NoteCreationParams params);
}