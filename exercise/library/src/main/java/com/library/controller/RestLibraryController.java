package com.library.controller;

import com.library.model.Book;
import com.library.service.itf.IBookService;
import com.library.service.itf.ICardService;
import com.library.service.itf.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/library")
public class RestLibraryController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICardService cardService;
    @Autowired
    private IStudentService studentService;

    @GetMapping("/page/book")
    public ResponseEntity<Page<Book>> displayBookPage(@RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<String> bookName) {
        Pageable pageable = PageRequest.of(page.orElse(0), 3);
        String strName = "%" + bookName.orElse("") + "%";
        Page<Book> bookPage = bookService.findBookPageByName(pageable, strName);
        if (bookPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/list/book")
    public ResponseEntity<Page<Book>> displayBookList() {
        List<Book> bookList = bookService.findAllBookList();
        if (bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
