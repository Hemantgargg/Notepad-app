package com.ys.notepad.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ys.notepad.service.NoteService;
import com.ys.notepad.model.Note;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin("*")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // CREATE NOTE
    @PostMapping("/add")
    public ResponseEntity<?> addNote(
            @RequestParam Long userId,
            @RequestParam String title,
            @RequestParam String content) {

        Note note = noteService.addNote(userId, title, content);
        return ResponseEntity.ok(note);
    }

    // GET NOTES
    @GetMapping("/list")
    public ResponseEntity<List<Note>> getNotes(@RequestParam Long userId) {
        return ResponseEntity.ok(noteService.getNotes(userId));
    }

    // DELETE NOTE
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteNote(
            @RequestParam Long noteId,
            @RequestParam Long userId) {

        try {
            noteService.deleteNote(noteId, userId);
            return ResponseEntity.ok("Note deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

