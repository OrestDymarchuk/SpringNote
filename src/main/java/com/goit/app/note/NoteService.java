package com.goit.app.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        noteRepository.save(note);
        return note;
    }

    public void deleteById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new NoSuchElementException("The note is missing");
        }
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        Optional<Note> notUpdate = noteRepository.findById(note.getId());
        if (notUpdate.isEmpty()) {
            throw new NoSuchElementException("The note is missing.");
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isEmpty()) {
            throw new NoSuchElementException("The note is missing");
        }
        return note.get();
    }
}
