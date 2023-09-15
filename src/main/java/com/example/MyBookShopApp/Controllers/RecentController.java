package com.example.MyBookShopApp.Controllers;

import com.example.MyBookShopApp.Data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecentController {

    private final BookService bookService;

    @Autowired
    public RecentController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/recents")
    public String recentsPage(){
        return "books/recent";
    }
}
