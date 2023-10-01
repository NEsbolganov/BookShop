package com.example.MyBookShopApp.Data.Services;

import com.example.MyBookShopApp.Data.Book;
import com.example.MyBookShopApp.Data.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByTitleContaining(searchWord,nextPage);
    }

    public Page<Book> getPageOfBooksBetweenDate(String from, String to, Integer offset, Integer limit) throws ParseException {
        Pageable nextPage = PageRequest.of(offset,limit);
        SimpleDateFormat format =  new SimpleDateFormat("dd.MM.yyyy");
        Date fromDate = format.parse(from);
        Date toDate = format.parse(to);
        return bookRepository.findBooksByPub_dateBetweenOrderByPub_dateDesc(fromDate,toDate,nextPage);
    }


}
