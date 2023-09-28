package com.example.MyBookShopApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.MyBookShopApp.Data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    private final BookService bookService;

    @Autowired
    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getPageOfRecommendedBooks(0,6).getContent();
    }


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
    public String getSearchResults(@PathVariable(value = "searchWord",required = false) String searchWordDto, Model model){
//        Logger.getLogger(MainController.class.getSimpleName()).info(searchWordDto.getExample());
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults", bookService.getPageOfSearchResultBooks(searchWordDto,0,5).getContent());
        return "/search/index";
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
