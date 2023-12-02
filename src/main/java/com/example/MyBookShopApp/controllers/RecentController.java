package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.DatePeriodDto;
import com.example.MyBookShopApp.data.services.BookService;
import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.SearchWordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecentController {

    private final BookService bookService;

    @Autowired
    public RecentController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/recents")
    public String recentsPage(){
        return "/books/recent";
    }

    @GetMapping("/books/recent")
    @ResponseBody
    public BooksPageDto getBooksBetweenPeriod(@RequestParam("offset") Integer offset,
                                              @RequestParam("limit") Integer limit,
                                              @RequestParam(value = "from",required = false)String from,
                                              @RequestParam(value = "to",required = false) String to
                                              ) throws ParseException {
        if(from!= null && !from.isEmpty()) return new BooksPageDto(bookService.getPageOfBooksBetweenDate(from,to,offset,limit).getContent());
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset,limit).getContent());
    }

    @GetMapping(value = {"/books/recent/page"})
    @ResponseBody
    public String getPeriodResults(@RequestParam("offset") Integer offset,
                                   @RequestParam("limit") Integer limit,
                                   @RequestParam(value = "from" ,required = false)String from,
                                   @RequestParam(value = "to",required = false)String to,
                                   Model model) throws ParseException {
        model.addAttribute("booksAtPeriod",bookService.getPageOfBooksBetweenDate(from,to,offset,limit));
        return "/books/recent";
    }



    @ModelAttribute("DatePeriodDto")
    public DatePeriodDto datePeriodDto(){
        return new DatePeriodDto();
    }
    @ModelAttribute("booksAtPeriod")
    public List<Book> booksAtPeriod(){
        return new ArrayList<>();
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
