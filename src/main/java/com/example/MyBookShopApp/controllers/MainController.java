package com.example.MyBookShopApp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.MyBookShopApp.data.*;
import com.example.MyBookShopApp.data.services.BookService;
import com.example.MyBookShopApp.data.services.TagService;
import com.example.MyBookShopApp.data.book.TagEntity;
import com.example.MyBookShopApp.errs.EmptySearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class MainController {

    private final BookService bookService;
    private final TagService tagService;

    @Autowired
    public MainController(BookService bookService, TagService tagService) {
        this.bookService = bookService;
        this.tagService = tagService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getPageOfRecommendedBooks(0,6).getContent();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks(){
        return bookService.getPageOfRecentBooks(0,6).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){
        return bookService.getPageOfPopularBooks(0,6).getContent();
    }


    @ModelAttribute("tagsList")
    public List<TagEntity> tagList(){
        return tagService.getTagsList();
    }

    @GetMapping("/books/popular")
    @ResponseBody
    public BooksPageDto getPopularBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfPopularBooks(offset,limit).getContent());
    }

//    @GetMapping("/books/recent")
//    @ResponseBody
//    public BooksPageDto getRecentBooksPage(@RequestParam("offset") Integer offset,
//                                           @RequestParam("limit") Integer limit){
//        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset,limit).getContent());
//    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset,limit).getContent());
    }

    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord",required = false) String searchWordDto, Model model) throws EmptySearchException {
        if(searchWordDto != null || searchWordDto.length()>0){
            model.addAttribute("searchWordDto", searchWordDto);
            model.addAttribute("searchResults", bookService.getPageOfSearchResultBooks(searchWordDto,0,5).getContent());
            return "/search/index";
        }else{
            throw new EmptySearchException("Поиск по null невозможен");
        }
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@PathVariable(value = "searchWord",required = false) String searchWordDto,
                                          @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto,offset,limit).getContent());
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
