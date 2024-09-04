package com.reine.ReinesbookStore;

import com.reine.ReinesbookStore.model.Book;
import com.reine.ReinesbookStore.repository.BookRepository;
import com.reine.ReinesbookStore.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book();
        book.setId(1);
        book.setName("Sample Book");
    }

    @Test
    public void testSave() {
        // Given
        when(bookRepository.save(book)).thenReturn(book);

        // When
        bookService.save(book);

        // Then
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testGetAllBook() {
        // Given
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));

        // When
        var books = bookService.getAllBook();

        // Then
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    @Test
    public void testGetBookById() {
        // Given
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        // When
        var result = bookService.getBookById(1);

        // Then
        assertNotNull(result);
        assertEquals(book, result);
    }

    @Test
    public void testDeleteById() {
        // Given
        doNothing().when(bookRepository).deleteById(1);

        // When
        bookService.deleteById(1);

        // Then
        verify(bookRepository, times(1)).deleteById(1);
    }
}
