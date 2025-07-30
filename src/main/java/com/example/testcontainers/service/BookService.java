package com.example.testcontainers.service;


import com.example.testcontainers.dto.BookDTO;
import com.example.testcontainers.entities.Book;

import java.util.List;

public interface BookService {
    BookDTO addBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

    Book getBookById(Long id);

    Book updateBook(BookDTO updatedBook, Long id);

    void deleteBook(Long id);

    Book patchBook(BookDTO updatedBook, Long id);
}
