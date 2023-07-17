package com.libraries.service.itf;

import com.libraries.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAllBookList();

    void addBook(Book book);

    void updateBook(Book book);

    Page<Book> findBookPageByName(Pageable pageable, String bookName);

    Book findBookById(int bookId);
}
