package com.goit.app.note;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NoteInteract {

    private final NoteService noteService;

    @PostConstruct
    public void noteInteraction() {
        Note note1 = new Note();
        note1.setTitle("Title1");
        note1.setContent("Content1");

        Note note2 = new Note();
        note2.setTitle("Title2");
        note2.setContent("Content2");

        Note note3 = new Note();
        note3.setTitle("Title3");
        note3.setContent("Content3");


        System.out.println(noteService.add(note1));
        System.out.println(noteService.add(note2));
        System.out.println(noteService.add(note3));


    }
}

