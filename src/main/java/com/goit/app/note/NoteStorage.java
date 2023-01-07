package com.goit.app.note;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteStorage {
    private List<Note> notes;

    public NoteStorage() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public List<Note> listNotes() {
        return this.notes;
    }

}
