package org.makovej.bookshopapp.controllers;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("authorList", authorService.getAllAuthors());
        return "authors/index";
    }
}
