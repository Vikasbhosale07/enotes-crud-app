package com.enotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enotes.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}