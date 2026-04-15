package com.layeredarchitecture.book.dto;

import lombok.Getter;

@Getter
public class CreateBookRequest {
    public String isbn;
    public  String title;
    public String author;
    public double price;
}
