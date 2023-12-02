package com.example.MyBookShopApp.data.services;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.errs.BookstoreApiWrongParameterException;
import com.example.MyBookShopApp.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// lombok, optional, stream api, sonarlint - plugin
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
        var nextPage = PageRequest.of(offset,limit);
        SimpleDateFormat format =  new SimpleDateFormat("dd.MM.yyyy");
        Date fromDate = format.parse(from);
        Date toDate = format.parse(to);
        return bookRepository.findBooksByPub_dateBetweenOrderByPub_dateDesc(fromDate,toDate,nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit, Sort.by("popularity").descending());
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfRecentBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAllBooks(nextPage);
    }

    public List<Book> getAuthorsBooks(Integer id){
        return bookRepository.findBooksByAuthorId(id);
    }


    public Page<Book> getBooksByGenreId(Integer offset, Integer limit, Integer genreId) {
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByGenre_id(nextPage,genreId);
    }

    public List<Book> getBooksByTitle(String title) throws BookstoreApiWrongParameterException {
        if(title.equals("") || title.length()<=1){
            throw new BookstoreApiWrongParameterException("Wrong values passed to one or more parameters");
        }else{
            List<Book> data = bookRepository.findBooksByTitleContaining(title);
            if(data.size()>0){
                return data;
            }else{
                throw new BookstoreApiWrongParameterException("No data found with specified parameters....");
            }
        }
    }
}
