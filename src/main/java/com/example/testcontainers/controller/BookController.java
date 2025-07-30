package com.example.testcontainers.controller;

import com.example.testcontainers.dto.BookDTO;
import com.example.testcontainers.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody @Valid BookDTO bookDTO){
        return ResponseEntity.ok(bookService.addBook(bookDTO));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> allBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long id){
        return ResponseEntity.ok(bookService.updateBook(bookDTO, id));
    }

    @PatchMapping("/books/{id}")
    public ResponseEntity<?> patchBook(@RequestBody BookDTO bookDTO, @PathVariable Long id){
        return ResponseEntity.ok(bookService.patchBook(bookDTO, id));
    }
}
