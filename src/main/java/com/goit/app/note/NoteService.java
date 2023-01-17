package com.goit.app.note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final NoteStorage noteStorage = new NoteStorage();

    public List<Note> listAll() {
        return noteStorage
                .getNotes()
                .values()
                .stream()
                .toList();
    }

    public Note add(Note note) {
        long id = new Random()
                .longs(1, 1000)
                .findFirst()
                .getAsLong();

        if (noteStorage
                .mapNotes()
                .values()
                .stream()
                .anyMatch(n -> n.getId() == id)) {
            throw new IllegalArgumentException("The note is already exists.");
        } else {
            note.setId(id);
            noteStorage.addNote(note);
        }

        return note;
    }

    public void deleteById(long id) {
        Note note = noteStorage.mapNotes()
                .values()
                .stream()
                .filter(n -> n.getId() == id)
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing.");
                });

        noteStorage.mapNotes().remove(note.getId());
    }

    public void update(Note note) {
        if (noteStorage.getNote(note.getId()) == null) {
            throw new NoSuchElementException("The note is missing.");
        }
        noteStorage.addNote(note);

    }

    public Note getById(long id) {
        return noteStorage.mapNotes()
                .values()
                .stream()
                .filter(n -> n.getId() == id)
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("The note is missing");
                });
    }
}
