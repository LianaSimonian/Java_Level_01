package com.aca.classroom.note.service.core;

import com.aca.classroom.note.entity.Note;

public interface NoteService {

    Note create(NoteCreationParams params);
}
