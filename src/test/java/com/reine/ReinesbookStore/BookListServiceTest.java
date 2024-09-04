package com.reine.ReinesbookStore;

import com.reine.ReinesbookStore.model.BookList;
import com.reine.ReinesbookStore.repository.BookListRepository;
import com.reine.ReinesbookStore.service.BookListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;

public class BookListServiceTest {

    @Mock
    private BookListRepository bookListRepository;

    @InjectMocks
    private BookListService bookListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveMyBooks() {
        BookList bookList = new BookList();
        bookListService.saveMyBooks(bookList);
        verify(bookListRepository, times(1)).save(bookList);
    }

    @Test
    void testGetAllMyBooks() {
        BookList bookList1 = new BookList();
        BookList bookList2 = new BookList();
        List<BookList> bookLists = Arrays.asList(bookList1, bookList2);

        when(bookListRepository.findAll()).thenReturn(bookLists);

        List<BookList> result = bookListService.getAllMyBooks();

        verify(bookListRepository, times(1)).findAll();
        assert(result.size() == 2);
    }

    @Test
    void testDeleteById() {
        int id = 1;

        bookListService.deleteById(id);

        verify(bookListRepository, times(1)).deleteById(id);
    }
}