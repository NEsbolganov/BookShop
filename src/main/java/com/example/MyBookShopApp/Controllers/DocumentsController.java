package com.example.MyBookShopApp.Controllers;

import com.example.MyBookShopApp.Data.Book;
import com.example.MyBookShopApp.Data.Services.BookService;
import com.example.MyBookShopApp.Data.SearchWordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DocumentsController {
    private final BookService bookService;

    @Autowired
    public DocumentsController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/documents")
    public String documentsPage(){
        return "documents/index";
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
