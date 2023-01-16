package com.goit.app.note;

import lombok.Data;

@Data
public class Note {
    private Long id;
    private String title;
    private String content;
}
