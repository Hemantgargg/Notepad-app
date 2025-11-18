package com.ys.notepad.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ys.notepad.model.Note;
import com.ys.notepad.model.User;
import com.ys.notepad.repository.NoteRepository;
import com.ys.notepad.repository.UserRepository;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Note addNote(Long userId, String title, String content) {
        User user = userRepository.findById(userId).orElseThrow(
            () -> new IllegalArgumentException("User not found")
        );

        Note note = Note.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();

        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNotes(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    @Override
    public void deleteNote(Long noteId, Long userId) {
        Note note = noteRepository.findById(noteId).orElseThrow(
            () -> new IllegalArgumentException("Note not found")
        );

        if (!note.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Unauthorized delete");
        }

        noteRepository.delete(note);
    }
}
