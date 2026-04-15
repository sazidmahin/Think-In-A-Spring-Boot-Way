package com.layeredarchitecture.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
@Setter
public class Book {
    @Id
    private String isbn;

    private String title;
    private String author;
    private Double price;
}
