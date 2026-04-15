package com.layeredarchitecture.book.repository;

import com.layeredarchitecture.book.dto.GetBookByIsbnRequest;
import com.layeredarchitecture.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    Optional<Book>getBookByIsbn(String isbn);
    List<Book> getAllBooks();
    Optional<Book>deleteBooksByIsbn(String isbn);
}
