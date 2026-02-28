package com.enotes.service;

import com.enotes.entity.Note;
import com.enotes.exception.NoteNotFoundException;
import com.enotes.repository.NoteRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    // Constructor Injection
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(Long id, Note note) {
        Note existingNote = noteRepository.findById(id).orElseThrow(()->new NoteNotFoundException("Note not Found"));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());

        return noteRepository.save(existingNote);
    }

    @Override
    public Note getNoteById(Long id) {

        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not Found"));
    }

    @Override
    public void deleteNote(Long id) {
        Note existingNote=noteRepository.findById(id).orElseThrow(()->new NoteNotFoundException("Note not Found"));
        noteRepository.delete(existingNote);

    }
}