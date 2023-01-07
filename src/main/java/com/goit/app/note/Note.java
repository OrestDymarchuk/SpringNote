package com.goit.app.note;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note() {
    }
}
