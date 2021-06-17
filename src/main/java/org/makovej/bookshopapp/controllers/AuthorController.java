package org.makovej.bookshopapp.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.makovej.bookshopapp.entities.Author;
import org.makovej.bookshopapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
@Api(description = "authors data")
public class AuthorController {

    private final AuthorService authorService;

    @ModelAttribute("authorsMap")
    public Map<String,List<Author>> authors(){
        return authorService.getAuthorsMap();
    }

    @GetMapping
    public String getMainPage() {
        return "/authors/index";
    }

    @ApiOperation("method to get all authors")
    @GetMapping("/api/author")
    @ResponseBody
    public Map<String, List<Author>> authorsMass(){
        return authorService.getAuthorsMap();
    }
}
