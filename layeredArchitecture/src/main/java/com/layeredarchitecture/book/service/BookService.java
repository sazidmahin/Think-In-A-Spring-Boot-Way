package com.layeredarchitecture.book.service;

import com.layeredarchitecture.book.dto.CreateBookRequest;
import com.layeredarchitecture.book.entity.Book;
import com.layeredarchitecture.book.exception.BookAlreadyExistsException;
import com.layeredarchitecture.book.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public  void createBook(CreateBookRequest createBookRequest)
    {
        bookRepository.getBookByIsbn(createBookRequest.getIsbn()).ifPresent(book -> {throw  new BookAlreadyExistsException("This Book Already Exists");});
        Book book=new Book();
        book.setIsbn(createBookRequest.getIsbn());
        book.setTitle(createBookRequest.getTitle());
        book.setAuthor(createBookRequest.getAuthor());
        book.setPrice(createBookRequest.getPrice());
    }
    public List<Book> getAllBooks()
    {
            return bookRepository.getAllBooks();
    }
    public  Optional<Book> getBookByIsbn(String  isbn)
    {
        return bookRepository.getBookByIsbn(isbn);
    }
    public Optional<Book>deleteBookByIsbn(String isbn)
    {
        return bookRepository.deleteBooksByIsbn(isbn);
    }
}
