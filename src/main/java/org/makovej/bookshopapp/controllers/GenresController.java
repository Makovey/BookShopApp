package org.makovej.bookshopapp.controllers;

import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenresController {

    @GetMapping
    public String getMainPage() {
        return "genres/index";
    }
}
