package com.enotes.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteRequestDTO {
    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    private String content;

    public NoteRequestDTO() {
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
