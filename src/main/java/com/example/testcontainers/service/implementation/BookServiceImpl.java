package com.example.testcontainers.service.implementation;

import com.example.testcontainers.dto.BookDTO;
import com.example.testcontainers.entities.Book;
import com.example.testcontainers.exception.BookNotFoundException;
import com.example.testcontainers.mappers.BookMapper;
import com.example.testcontainers.repository.BookRepository;
import com.example.testcontainers.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO){
        Book book = BookMapper.toEntity(bookDTO);
        return BookMapper.toDTO(bookRepository.save(book));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toDTO).toList();
    }

    @Override
    public Book getBookById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public Book updateBook(BookDTO updatedBook, Long id){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book with id " + id + " not found"));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());

        return existingBook;
    }

    @Override
    public void deleteBook(Long id){
        Book bookToDelete = bookRepository.findById(id)
                        .orElseThrow(()-> new BookNotFoundException("Book with id " + id + " not found"));
        bookRepository.delete(bookToDelete);
    }

    @Override
    public Book patchBook(BookDTO updatedBook, Long id){
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book with id " + id + " not found"));

        if(updatedBook.getTitle() != null && !updatedBook.getTitle().trim().isEmpty()){
            existingBook.setTitle(updatedBook.getTitle());
        }
        if(updatedBook.getAuthor() != null && !updatedBook.getAuthor().trim().isEmpty()){
            existingBook.setAuthor(updatedBook.getAuthor());
        }
        return bookRepository.save(existingBook);
    }
}
