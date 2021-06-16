package org.makovej.bookshopapp.services;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.entities.Book;
import org.makovej.bookshopapp.repositories.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

}
