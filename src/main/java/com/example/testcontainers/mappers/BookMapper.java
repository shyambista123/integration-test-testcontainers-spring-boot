package com.example.testcontainers.mappers;

import com.example.testcontainers.dto.BookDTO;
import com.example.testcontainers.entities.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book){
        return new BookDTO(book.getTitle(), book.getAuthor());
    }

    public static Book toEntity(BookDTO bookDTO){
        return new Book(bookDTO.getTitle(), bookDTO.getAuthor());
    }
}
