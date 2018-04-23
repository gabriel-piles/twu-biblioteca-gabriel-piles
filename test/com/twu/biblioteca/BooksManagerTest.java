package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BooksManagerTest {

    @Test
    public void get_list_of_books_initialize() {
        BooksManager book_manager = new BooksManager("test.txt");
        List<Book> all_books = book_manager.get_list_of_books();
        assertEquals(all_books.size(), 2);
    }

    @Test
    public void get_list_of_books_first_book() {
        BooksManager book_manager = new BooksManager("test.txt");
        List<Book> all_books = book_manager.get_list_of_books();
        Book first_book = all_books.get(0);
        // first book--gabriel piles--2009--yes
        assertEquals("first book", first_book.getName());
        assertEquals("gabriel piles", first_book.getAuthor());
        assertEquals(2009, first_book.getYear());
        assertEquals(true, first_book.getAvailability());
    }

    @Test
    public void get_list_of_books_second_book() {
        BooksManager book_manager = new BooksManager("test.txt");
        List<Book> all_books = book_manager.get_list_of_books();
        Book second_book = all_books.get(1);
        // second book--gabriel piles--2007--no
        assertEquals("second book", second_book.getName());
        assertEquals("gabriel piles", second_book.getAuthor());
        assertEquals(2007, second_book.getYear());
        assertEquals(false, second_book.getAvailability());
    }
}
