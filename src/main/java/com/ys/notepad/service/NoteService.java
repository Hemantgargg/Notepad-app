package com.ys.notepad.service;


import java.util.List;
import com.ys.notepad.model.Note;

public interface NoteService {

    Note addNote(Long userId, String title, String content);

    List<Note> getNotes(Long userId);

    void deleteNote(Long noteId, Long userId);
}
