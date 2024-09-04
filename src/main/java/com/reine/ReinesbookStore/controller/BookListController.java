package com.reine.ReinesbookStore.controller;

import com.reine.ReinesbookStore.service.BookListService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookListController {

    private final BookListService bookListService;

    @Autowired
    public BookListController(BookListService bookListService){
        this.bookListService = bookListService;
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        bookListService.deleteById(id);
        return "redirect:/my_books";
    }
}
