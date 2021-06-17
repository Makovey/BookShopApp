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

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepo.findBooksByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max) {
        return bookRepo.findBooksByPriceOldBetween(min, max);
    }

    public List<Book> findBooksByPriceOldIs(Integer price) {
        return bookRepo.findBooksByPriceOldIs(price);
    }

    public List<Book> getBestsellers() {
        return bookRepo.getBestsellers();
    }

    public List<Book> getBooksWithMaxDiscount() {
        return bookRepo.getBooksWithMaxDiscount();
    }

}
