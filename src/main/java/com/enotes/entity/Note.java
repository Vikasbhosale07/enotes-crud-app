package com.enotes.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // Default Constructor (Required by JPA)
    public Note() {
    }

    // Constructor without ID (ID is auto-generated)
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // No setter for ID (optional but recommended)
    // ID should not be manually modified

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