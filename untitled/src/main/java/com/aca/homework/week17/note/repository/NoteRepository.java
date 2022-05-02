package com.aca.homework.week17.note.repository;

import com.aca.homework.week17.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
