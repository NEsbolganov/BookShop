package com.example.MyBookShopApp.data.repositories;

import com.example.MyBookShopApp.data.book.file.BookFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookFileRepository extends JpaRepository<BookFile, Integer> {
    public BookFile findBookFileByHash(String hash);
}
