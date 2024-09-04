package com.reine.ReinesbookStore.service;

import java.util.List;

import com.reine.ReinesbookStore.model.Book;
import com.reine.ReinesbookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
