package com.goit.app.note;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class NoteStorage {
    private Map<Long,Note> notes;

    public NoteStorage() {
        notes = new HashMap<>();
    }

    public void addNote(Note note) {
        this.notes.put(note.getId(), note);
    }

    public Map<Long,Note> mapNotes() {
        return this.notes;
    }

}
