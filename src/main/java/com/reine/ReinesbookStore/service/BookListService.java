package com.reine.ReinesbookStore.service;

import java.util.List;
import com.reine.ReinesbookStore.model.BookList;
import com.reine.ReinesbookStore.repository.BookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookListService {

    private final BookListRepository bookListRepository;

    @Autowired
    public BookListService(BookListRepository bookListRepository){
        this.bookListRepository=bookListRepository;
    }

    public void saveMyBooks(BookList bookList) {
        bookListRepository.save(bookList);
    }

    public List<BookList> getAllMyBooks(){
        return bookListRepository.findAll();
    }

    public void deleteById(int id) {
        bookListRepository.deleteById(id);
    }
}
