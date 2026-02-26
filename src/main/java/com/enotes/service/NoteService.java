package com.enotes.service;

import com.enotes.entity.Note;

import java.util.List;

public interface NoteService {

    Note saveNote(Note note);

    List<Note> getAllNotes();

    Note updateNote(Integer id, Note note);

    void deleteNote(Integer id);
}
