package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void listAvailableBooks() {

        BibliotecaApp bibliotecaApp = initializeBibliotecaApp();

        List<Book> listAvailableBooks = bibliotecaApp.listAvailableBooks();

        assertEquals(1, listAvailableBooks.size());

        Book first_book = listAvailableBooks.get(0);
        // first book--gabriel piles--2009--yes
        assertEquals("first book", first_book.getName());
    }

    @Test
    public void listCheckOutBooks() {

        BibliotecaApp bibliotecaApp = initializeBibliotecaApp();

        List<Book> listCheckOutBooks = bibliotecaApp.listCheckOutBooks();

        assertEquals(1, listCheckOutBooks.size());

        Book second_book = listCheckOutBooks.get(0);
        assertEquals("second book", second_book.getName());
    }

    @Test
    public void checkOutBookFail() {

        BibliotecaApp bibliotecaApp = initializeBibliotecaApp();

        assertEquals(false, bibliotecaApp.checkOutBook(""));
        assertEquals(false, bibliotecaApp.checkOutBook("second book"));
    }

    @Test
    public void checkOutBook() {

        BibliotecaApp bibliotecaApp = initializeBibliotecaApp();

        assertEquals(true, bibliotecaApp.checkOutBook("first book"));
        List<Book> listAvailableBooks = bibliotecaApp.listAvailableBooks();

        assertEquals(0, listAvailableBooks.size());
    }

    @Test
    public void returnBookFail() {

        BibliotecaApp bibliotecaApp = initializeBibliotecaApp();

        assertEquals(false, bibliotecaApp.returnBook(""));
        assertEquals(false, bibliotecaApp.returnBook("first book"));
    }

    @Test
    public void returnBookBook() {

        BibliotecaApp bibliotecaApp = initializeBibliotecaApp();

        assertEquals(true, bibliotecaApp.returnBook("second book"));
        List<Book> listAvailableBooks = bibliotecaApp.listAvailableBooks();

        assertEquals(2, listAvailableBooks.size());
    }

    private BibliotecaApp initializeBibliotecaApp() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initializeBooksManager("test.txt");

        return  bibliotecaApp;
    }
}
