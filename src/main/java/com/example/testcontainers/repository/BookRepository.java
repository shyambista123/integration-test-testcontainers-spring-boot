package com.example.testcontainers.repository;

import com.example.testcontainers.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByTitle(String title);
}
