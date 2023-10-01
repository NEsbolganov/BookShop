package com.example.MyBookShopApp.Controllers;

import com.example.MyBookShopApp.Data.*;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiOperation;
import com.example.MyBookShopApp.Data.Services.AuthorsService;
import com.example.MyBookShopApp.Data.Services.BookService;
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


    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }
}
