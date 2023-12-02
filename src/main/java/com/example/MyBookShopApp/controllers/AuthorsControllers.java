package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiOperation;
import com.example.MyBookShopApp.data.services.AuthorsService;
import com.example.MyBookShopApp.data.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
//@Api(description = "authors data")
public class AuthorsControllers {

    private final AuthorsService authorsService;
    private final BookService bookService;

    @Autowired
    public AuthorsControllers(AuthorsService authorsService, BookService bookService) {
        this.authorsService = authorsService;
        this.bookService = bookService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap(){
        return authorsService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage(Model model){
        return "authors/index";
    }

    @GetMapping("/api/authors")
//    @ApiOperation("method to get authors data")
    @ResponseBody
    public Map<String, List<Author>> authors(){
        return authorsService.getAuthorsMap();
    }

    @GetMapping("/authors/{slug}")
    public String authorPage(@PathVariable("slug")String slug, Model model){
        model.addAttribute("author", authorsService.getAuthorBySlug(slug));
        Integer authorId =  authorsService.getAuthorIdBySlug(slug);
        model.addAttribute("authorsBooks",bookService.getAuthorsBooks(authorId));
        return "/authors/slug";
    }

    @GetMapping("/books/author/{slug}")
    public String authorsBooks(@PathVariable("slug") String slug, Model model){
        Integer authorId =  authorsService.getAuthorIdBySlug(slug);
        model.addAttribute("author", authorsService.getAuthorBySlug(slug));
        model.addAttribute("authorsBooks",bookService.getAuthorsBooks(authorId));
        return "/books/author";
    }


    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }
}
