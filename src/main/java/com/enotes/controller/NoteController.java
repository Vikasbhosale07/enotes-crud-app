package com.enotes.controller;

import com.enotes.dto.NoteRequestDTO;
import com.enotes.entity.Note;
import com.enotes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note saveNote(@Valid @RequestBody NoteRequestDTO noteRequestDTO) {

        // Convert DTO → Entity
        Note note = new Note();
        note.setTitle(noteRequestDTO.getTitle());
        note.setContent(noteRequestDTO.getContent());

        return noteService.saveNote(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id,
                           @Valid @RequestBody NoteRequestDTO noteRequestDTO) {

        Note note = new Note();
        note.setTitle(noteRequestDTO.getTitle());
        note.setContent(noteRequestDTO.getContent());

        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "Note deleted successfully";
    }
}