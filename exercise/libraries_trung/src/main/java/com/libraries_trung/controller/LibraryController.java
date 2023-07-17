package com.libraries_trung.controller;

import com.libraries_trung.exception.OffBookException;
import com.libraries_trung.model.Book;
import com.libraries_trung.model.Student;
import com.libraries_trung.service.itf.IBookService;
import com.libraries_trung.service.itf.IStudentService;
import com.libraries_trung.dto.BorrowBookCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/library")
public class LibraryController {
    private IBookService bookService;
    private IStudentService studentService;

    //    private ICardService cardService;
//
    private LibraryController(IBookService bookService,
                              IStudentService studentService) {
//                              ICardService cardService) {
        this.bookService = bookService;
        this.studentService = studentService;
//        this.cardService = cardService;
    }

    @ModelAttribute("students")
    public List<Student> getStudentList() {
        return studentService.findAllStudentList();
    }

    @ModelAttribute("book")
    public Book getBook() {
        return new Book();
    }

    @ModelAttribute("student")
    public Student getStudent() {
        return new Student();
    }

//    @ModelAttribute("card")
//    public Card getCard(){
//        return new Card();
//    }

    @GetMapping("/book")
    public String showBookPage(@RequestParam Optional<Integer> page,
                               @RequestParam(defaultValue = "") String bookName,
                               Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Book> bookPage = bookService.findBookPageByName(pageable, "%" + bookName + "%");
        model.addAttribute("bookPage", bookPage);
        model.addAttribute("bookName", bookName);
        return "library/book";
    }

    @GetMapping("/student")
    public String showStudentPage(@RequestParam Optional<Integer> page,
                                  @RequestParam(defaultValue = "") String studentName,
                                  Model model) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Student> studentPage = studentService.findStudentPageByName(pageable, "%" + studentName + "%");
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("studentName", studentName);
        return "library/student";
    }

    //    @GetMapping("/card")
//    public String showCardPage(@RequestParam Optional<Integer> page,
//                               @RequestParam(defaultValue = "") String bookName,
//                               Model model) {
//        Pageable pageable = PageRequest.of(page.orElse(0), 10);
//        Page<Card> cardPage = cardService.findAllCardPage(pageable, "%" + bookName + "%");
//        model.addAttribute("cardPage", cardPage);
//        model.addAttribute("bookName", bookName);
//        return "library/card";
//    }
//
//    @PostMapping("/book/add")
//    public String createBook(@ModelAttribute Book book) {
//        bookService.addBook(book);
//        return "redirect:/library/book";
//    }
//
//    @PostMapping("/student/add")
//    public String createStudent(@ModelAttribute Student student) {
//        studentService.addStudent(student);
//        return "redirect:/library/student";
//    }
//
//    @PostMapping("/student/update")
//    public String updateStudent(@ModelAttribute Student student) {
//        studentService.updateStudent(student);
//        return "redirect:/library/student";
//    }
//
//    @PostMapping("/book/update")
//    public String updateBook(@ModelAttribute Book book) {
//        bookService.updateBook(book);
//        return "redirect:/library/book";
//    }
//
    @PostMapping("/book/initBorrow")
    public String initBorrowBook(@RequestParam String[] checkedBook,
                                 Model model) throws OffBookException {
        List<Book> bookList = new ArrayList<>();
        BorrowBookCard borrowBookCardCard = new BorrowBookCard();
        for (String str : checkedBook) {
            bookList.add(bookService.findBookById(Integer.parseInt(str)));
        }
        model.addAttribute("bookList", bookList);
        model.addAttribute("borrowCard", borrowBookCardCard);
        return "library/createCard";
    }

    @PostMapping(value = "/book/borrow")
    public String borrowBook(@ModelAttribute(name = "borrowCard") BorrowBookCard borrowBookCard) {
        System.out.println("come here");
//        for (Book b : books) {
//            System.out.println(b.getBookName());
//        }
        return "redirect:/library/card";
    }

//    @PostMapping("/card/returnBook")
//    public String returnBook(@ModelAttribute Card card,
//                             RedirectAttributes redirectAttributes) {
//        Card returnCard = cardService.findCardById(card.getCardId());
//        returnCard.setStatus(true);
//        returnCard.setReturnDate(card.getReturnDate());
//        cardService.updateCard(returnCard);
//
//        Book book = bookService.findBookById(returnCard.getBook().getBookId());
//        int newQuantity = book.getQuantity() + 1;
//        book.setQuantity(newQuantity);
//        bookService.updateBook(book);
//
//        String msgReturn = "Returning book is successful!";
//        redirectAttributes.addFlashAttribute("msgReturn", msgReturn);
//        return "redirect:/library/card";
//    }
//
//    @ExceptionHandler(OffBookException.class)
//    public String offBookException() {
//        return "library/offBookException";
//    }
}
