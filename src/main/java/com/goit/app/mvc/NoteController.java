package com.goit.app.mvc;

import com.goit.app.note.Note;
import com.goit.app.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getNotes() {
        ModelAndView modelAndView = new ModelAndView("note/note");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String createNote() {
        return ("note/create-note");
    }

    @PostMapping("/create")
    public RedirectView create(@RequestParam("title") String title, @RequestParam("content") String content) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/note/list");
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return redirectView;
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam long id) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/note/list");
        noteService.deleteById(id);
        return redirectView;
    }

    @GetMapping("/edit")
    public String editNote() {
        return ("note/edit-note");
    }

    @PostMapping("/edit")
    public RedirectView edit(@RequestParam long id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/note/list");

        Note note = noteService.getById(id);

        note.setTitle(title);
        note.setContent(content);

        noteService.update(note);

        return redirectView;
    }
}
