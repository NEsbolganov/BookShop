package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.repositories.BookRepository;
import com.example.MyBookShopApp.data.ResourceStorage;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookRepository bookRepository;
    private final ResourceStorage resourceStorage;
    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    @Autowired
    public BooksController(BookRepository bookRepository, ResourceStorage resourceStorage, BookService bookService) {
        this.bookRepository = bookRepository;
        this.resourceStorage = resourceStorage;
    }

    @GetMapping("/{slug}")
    public String bookPage(@PathVariable("slug") String slug, Model model) throws JsonProcessingException {
        Book book = bookRepository.findBookBySlug(slug);
        model.addAttribute("slugBook",book);
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("opening the page of slugBook, its info: "+objectMapper.writeValueAsString(book));
        return "/books/slug";
    }

    @PostMapping("/{slug}/img/save")
    public String saveNewImage(@PathVariable("slug") String slug,
                               @RequestParam("file")MultipartFile file) throws IOException {
        String savePath = resourceStorage.saveNewBookImage(file,slug);
        Book bookToUpdate = bookRepository.findBookBySlug(slug);
        bookToUpdate.setImage(savePath);
        bookRepository.save(bookToUpdate);//save new path in DB
        return ("redirect:/books/"+slug);
    }

    @GetMapping("/download/{hash}")
    public ResponseEntity<ByteArrayResource> downloadBook(@PathVariable("hash")String hash) throws IOException {
        Path path = resourceStorage.getBookFilePath(hash);

        logger.info("book file path: "+path);

        MediaType mediaType = resourceStorage.getBookFileMime(hash);

        logger.info("book file mime type: "+mediaType);

        byte[] data = resourceStorage.getBookFileByteArray(hash);


        logger.info("book file data len: "+data.length);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+path.getFileName().toString())
                .contentType(mediaType)
                .contentLength(data.length)
                .body(new ByteArrayResource(data));
    }
}
