package com.library.service.impl;

import com.library.model.Book;
import com.library.repository.IBookRepository;
import com.library.service.itf.IBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private IBookRepository bookRepository;

    private BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBookList() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Page<Book> findBookPageByName(Pageable pageable, String bookName) {
        return bookRepository.findBookPageByName(pageable, bookName);
    }

    @Override
    public Book findBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }
}
