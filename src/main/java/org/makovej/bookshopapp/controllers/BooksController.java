package org.makovej.bookshopapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    @GetMapping("/recent")
    public String getRecentPage(){
        return "/books/recent";
    }


    @GetMapping("/popular")
    public String getPopularPage(){
        return "/books/popular";
    }

    @GetMapping("/slug")
    public String getSlugPage(){
        return "/books/slug";
    }
}
