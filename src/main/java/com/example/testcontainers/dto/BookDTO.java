package com.example.testcontainers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDTO {
    @NotBlank
    @Size(min = 2, max = 50, message = "Title should not be blank and should contain at least 2 character")
    private String title;

    @NotBlank
    @Size(min = 3, max = 30, message = "Author should not be blank and should contain at least 3 character")
    private String author;

    public BookDTO(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
