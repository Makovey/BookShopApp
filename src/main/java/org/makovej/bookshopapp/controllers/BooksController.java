package org.makovej.bookshopapp.controllers;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.dto.BooksPageDto;
import org.makovej.bookshopapp.dto.SearchWordDto;
import org.makovej.bookshopapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ModelAttribute("newBooks")
    @ResponseBody
    public BooksPageDto newBooks() {
        String from = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String to = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return new BooksPageDto(bookService.getPageOfNewBooks(from, to, 0, 15).getContent());
    }

    @GetMapping("/news")
    public String getRecentPage(){
        return "/books/news";
    }

    @GetMapping("/popular")
    public String getPopularPage() {
        return "/books/popular";
    }

    @GetMapping("/slug")
    public String getSlugPage() {
        return "/books/slug";
    }

    @GetMapping("/recommended")
    @ResponseBody
    public BooksPageDto getRecommendedBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset, limit).getContent());
    }

    @GetMapping("/recent")
    @ResponseBody
    public BooksPageDto getNewBooksPagee(
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to,
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfNewBooks(from, to, offset, limit).getContent());
    }

    @GetMapping("/popular-books")
    @ResponseBody
    public BooksPageDto getPopularBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfHighestRatingBooks(offset, limit).getContent());
    }
}
