package org.makovej.bookshopapp.controllers;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.entities.Book;
import org.makovej.bookshopapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final BookService bookService;

    @ModelAttribute("bookList")
    public List<Book> recommendedBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping
    public String getMainPage() {
        return "/index";
    }

    @GetMapping("/postponed")
    public String getPostponedPage() {
        return "/postponed";
    }

    @GetMapping("/cart")
    public String getCartPage() {
        return "/cart";
    }
}
