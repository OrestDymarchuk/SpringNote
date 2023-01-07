package com.goit.app.note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final NoteStorage noteStorage = new NoteStorage();

    public List<Note> listAll() {
        return noteStorage.listNotes();
    }

    public Note add(Note note) {
        Note newNote = new Note();
        long id = new Random()
                .longs(1, 1000)
                .findFirst()
                .getAsLong();

        if (noteStorage.listNotes().stream().anyMatch(n -> n.getId() == id)) {
            throw new IllegalArgumentException("The note is already exists.");
        } else {
            newNote.setId(id);
            newNote.setTitle(note.getTitle());
            newNote.setContent(note.getContent());
            noteStorage.addNote(newNote);
        }

        return newNote;
    }

    public void deleteById(long id) {
        Note note = noteStorage.listNotes()
                .stream()
                .filter(n -> n.getId() == id)
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing.");
                });

        noteStorage.listNotes().remove(note);
    }

    public void update(Note note) {
        Note noteUpdate = noteStorage.listNotes()
                .stream()
                .filter(n -> n.getId() == note.getId())
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing.");
                });

        noteUpdate.setTitle(note.getTitle());
        noteUpdate.setContent(note.getContent());

    }

    public Note getById(long id) {
        return noteStorage.listNotes()
                .stream()
                .filter(n -> n.getId() == id)
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing");
                });
    }
}
