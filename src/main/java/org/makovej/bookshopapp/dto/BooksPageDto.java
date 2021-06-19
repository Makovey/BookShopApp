package org.makovej.bookshopapp.dto;

import lombok.Data;
import org.makovej.bookshopapp.entities.Book;

import java.util.List;

@Data
public class BooksPageDto {
    private Integer count;
    private List<Book> books;

    public BooksPageDto(List<Book> books) {
        this.count = books.size();
        this.books = books;
    }
}
