package org.makovej.bookshopapp.controllers;

import org.makovej.bookshopapp.dto.SearchWordDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping("/news")
    public String getRecentPage(){
        return "/books/news";
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
