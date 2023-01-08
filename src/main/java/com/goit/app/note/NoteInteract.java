package com.goit.app.note;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class NoteInteract {

    @PostConstruct
    public void noteInteraction() {
        NoteService noteService = new NoteService();

        Note note1 = new Note();
        note1.setTitle("Title1");
        note1.setContent("Content1");

        Note note2 = new Note();
        note2.setTitle("Title2");
        note2.setContent("Content2");

        Note note3 = new Note();
        note3.setTitle("Title3");
        note3.setContent("Content3");


        System.out.println("Add note.");
        System.out.println(noteService.add(note1));
        System.out.println(noteService.add(note2));
        System.out.println(noteService.add(note3));
        System.out.println();

        System.out.println("Get list of notes.");
        noteService.listAll().forEach(System.out::println);
        System.out.println();

        Note note = noteService.listAll().get(2);
        note.setTitle("Title updated");
        note.setContent("Content updated");
        noteService.update(note);

        System.out.println("Note updated and got by id.");
        System.out.println(noteService.getById(note.getId()));
        System.out.println();

        System.out.println("Note deleted.");
        noteService.deleteById(note.getId());
        noteService.listAll().forEach(System.out::println);

    }
}
