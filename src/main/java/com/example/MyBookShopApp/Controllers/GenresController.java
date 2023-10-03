package com.example.MyBookShopApp.Controllers;

import com.example.MyBookShopApp.Data.Book;
import com.example.MyBookShopApp.Data.BooksPageDto;
import com.example.MyBookShopApp.Data.Services.BookService;
import com.example.MyBookShopApp.Data.SearchWordDto;
import com.example.MyBookShopApp.Data.Services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenresController {

    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public GenresController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public String genresPage(Model model){
        model.addAttribute("genresList",genreService.getAllGenres());
        return "genres/index";
    }


    @GetMapping("/genre/{slug}")
    public String genrePage(@PathVariable("slug") String slug, Model model){
        model.addAttribute("genre",genreService.getGenreBySlug(slug));
        return "/genres/slug";
    }

    @ModelAttribute("genresBooks")
    public List<Book> getGenresBooks(){
        return new ArrayList<>();
    }

    @GetMapping("/books/genre/{slug}")
    @ResponseBody
    public BooksPageDto getNextGenresBooksPage(@RequestParam("offset") Integer offset,
                                               @RequestParam("limit") Integer limit,
                                               @PathVariable("slug") String slug,
                                               Model model){
        Integer genre_id = genreService.getGenreBySlug(slug).getId();
        model.addAttribute("genresBooks", bookService.getBooksByGenreId(0,5,genre_id).getContent());
        return new BooksPageDto(bookService.getBooksByGenreId(offset,limit,genre_id).getContent());
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
