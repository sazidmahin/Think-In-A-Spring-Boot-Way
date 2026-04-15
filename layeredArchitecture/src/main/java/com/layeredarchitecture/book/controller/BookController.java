package com.layeredarchitecture.book.controller;

import com.layeredarchitecture.book.dto.CreateBookRequest;
import com.layeredarchitecture.book.dto.GetBookByIsbnRequest;
import com.layeredarchitecture.book.entity.Book;
import com.layeredarchitecture.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create-book")
    public String CreateBook(@RequestBody CreateBookRequest createBookRequest)
    {
        bookService.createBook(createBookRequest);
        return "Book Created Successfully";
    }
    @GetMapping("/get-all-books")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }
    @GetMapping("/get-book-by-isbn/{isbn}")
    public Optional<Book> getBookById(@PathVariable GetBookByIsbnRequest getBookByIsbnRequest)
    {
        return bookService.getBookByIsbn(getBookByIsbnRequest.getIsbn());
    }
    @DeleteMapping("/delete-by-isbn/{isbn}")
    public Optional<Book> deleteBookById(@PathVariable GetBookByIsbnRequest getBookByIsbnRequest)
    {
        return bookService.deleteBookByIsbn(getBookByIsbnRequest.getIsbn());
    }
}
