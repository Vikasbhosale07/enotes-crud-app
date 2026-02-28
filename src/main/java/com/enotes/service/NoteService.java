package com.enotes.service;

import com.enotes.entity.Note;

import java.util.List;

public interface NoteService {

    Note saveNote(Note note);

    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);
}
