package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;
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

    @Test
    public void listAvailableBooks() {

        BooksManager bookManager = initializeBookManagerForTesting();

        List<Book> listAvailableBooks = bookManager.listAvailableBooks();

        assertEquals(1, listAvailableBooks.size());

        Book first_book = listAvailableBooks.get(0);
        // first book--gabriel piles--2009--yes
        assertEquals("first book", first_book.getName());
    }

    @Test
    public void listCheckOutBooks() {

        BooksManager bookManager = initializeBookManagerForTesting();

        List<Book> listCheckOutBooks = bookManager.listCheckOutBooks();

        assertEquals(1, listCheckOutBooks.size());

        Book second_book = listCheckOutBooks.get(0);
        assertEquals("second book", second_book.getName());
    }

    @Test
    public void checkOutBookFail() {

        BooksManager bookManager = initializeBookManagerForTesting();

        assertEquals(false, bookManager.checkOutBook(""));
        assertEquals(false, bookManager.checkOutBook("second book"));
    }

    @Test
    public void checkOutBook() {

        BooksManager bookManager = initializeBookManagerForTesting();

        assertEquals(true, bookManager.checkOutBook("first book"));
        List<Book> listAvailableBooks = bookManager.listAvailableBooks();

        assertEquals(0, listAvailableBooks.size());
    }

    @Test
    public void returnBookFail() {

        BooksManager bookManager = initializeBookManagerForTesting();

        assertEquals(false, bookManager.returnBook(""));
        assertEquals(false, bookManager.returnBook("first book"));
    }

    @Test
    public void returnBookBook() {

        BooksManager bookManager = initializeBookManagerForTesting();

        assertEquals(true, bookManager.returnBook("second book"));
        List<Book> listAvailableBooks = bookManager.listAvailableBooks();

        assertEquals(2, listAvailableBooks.size());
    }

    private BooksManager initializeBookManagerForTesting() {
        BooksManager bookManager = new BooksManager("test.txt");
        return  bookManager;
    }
}
