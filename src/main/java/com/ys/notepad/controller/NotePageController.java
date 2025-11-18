package com.ys.notepad.controller;

import com.ys.notepad.model.Note;
import com.ys.notepad.repository.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotePageController {

    private final NoteRepository noteRepository;

    public NotePageController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes/edit/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        model.addAttribute("note", note);
        return "edit-note";
    }

    @PostMapping("/notes/update")
    public String updateNote(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String content) {

        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        note.setTitle(title);
        note.setContent(content);

        noteRepository.save(note);

        return "redirect:/notes";
    }
}
