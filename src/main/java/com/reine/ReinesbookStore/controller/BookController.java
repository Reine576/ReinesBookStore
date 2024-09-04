package com.reine.ReinesbookStore.controller;

import com.reine.ReinesbookStore.model.Book;
import com.reine.ReinesbookStore.model.BookList;
import com.reine.ReinesbookStore.service.BookListService;
import com.reine.ReinesbookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;


@Controller
public class BookController {

    private final BookService bookService;
    private final BookListService bookListService;

    @Autowired
    public BookController(BookService bookService, BookListService bookListService){
        this.bookService=bookService;
        this.bookListService=bookListService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "book_register";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book>list = bookService.getAllBook();
//     ModelAndView m=new ModelAndView();
//     m.setViewName("bookList");
//     m.addObject("book",list);
        return new ModelAndView("book_list","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<BookList>list=bookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "my_books";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        BookList mb = new BookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        bookListService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book_edit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }

}
