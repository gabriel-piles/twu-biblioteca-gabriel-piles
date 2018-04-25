package com.twu.biblioteca;


import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BooksManagerTest {

    @Test
    public void getListOfBooksInitialize() {
        BooksManager book_manager = new BooksManager("test.txt");
        Map<String, Book> all_books = book_manager.getAllBooks();
        assertEquals(all_books.size(), 2);
    }

    @Test
    public void getListOfBooksFirstBook() {
        BooksManager booksManager = new BooksManager("test.txt");
        Map<String, Book> listOfBooks = booksManager.getAllBooks();
        Book first_book = listOfBooks.get("first book");
        // first book--gabriel piles--2009--yes
        assertEquals("first book", first_book.getName());
        assertEquals("gabriel piles", first_book.getAuthor());
        assertEquals(2009, first_book.getYear());
        assertEquals(true, first_book.isAvailable());
    }

    @Test
    public void getListOfBooksSecondBook() {
        BooksManager booksManager = new BooksManager("test.txt");
        Map<String, Book> listOfBooks = booksManager.getAllBooks();
        Book second_book = listOfBooks.get("second book");
        // second book--gabriel piles--2007--no
        assertEquals("second book", second_book.getName());
        assertEquals("gabriel piles", second_book.getAuthor());
        assertEquals(2007, second_book.getYear());
        assertEquals(false, second_book.isAvailable());
    }
}
