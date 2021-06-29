package org.makovej.bookshopapp.services;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.makovej.bookshopapp.entities.Book;
import org.makovej.bookshopapp.repositories.BookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepo.findBooksByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max) {
        return bookRepo.findBooksByPriceOldBetween(min, max);
    }

    public List<Book> getBestsellers() {
        return bookRepo.getBestsellers();
    }

    public List<Book> getBooksWithMaxDiscount() {
        return bookRepo.getBooksWithMaxDiscount();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findBooksByTitleContaining(searchWord, nextPage);
    }

    public Page<Book> getPageOfNewBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findBooksByOrderByPubDateDesc(nextPage);
    }

    @SneakyThrows
    public Page<Book> getPageOfNewBooks(String from, String to, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        if (from == null || from.isEmpty() || to.isEmpty()) {
            return bookRepo.findBooksByOrderByPubDateDesc(nextPage);
        }
        Date parsedFromDate = new SimpleDateFormat("dd.MM.yyyy").parse(from);
        Date parsedToDate = new SimpleDateFormat("dd.MM.yyyy").parse(to);
        return bookRepo.findBooksByPubDateBetween(parsedFromDate, parsedToDate, nextPage);
    }

    public Page<Book> getPageOfHighestRatingBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findBooksByOrderByRatingDesc(nextPage);
    }

    public Page<Book> getPopularBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepo.findBooksByCalculatedPopularityDesc(nextPage);
    }

}
