package org.makovej.bookshopapp.controllers;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
@RequiredArgsConstructor
public class MainPageController {

    private final BookService bookService;

    @GetMapping("/main")
    public String getMainPage(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "index";
    }
}
