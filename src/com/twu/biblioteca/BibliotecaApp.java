package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    BooksManager booksManager;

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void initializeBooksManager(String fileListOfBooks) {
        this.booksManager = new BooksManager(fileListOfBooks);
    }

    public List<Book> listAvailableBooks() {
        return this.booksManager.getBooksSatisfyCondition(true);
    }

    public List<Book> listCheckOutBooks() {
        return this.booksManager.getBooksSatisfyCondition(false);
    }

    public boolean checkOutBook(String bookName) {

        return this.booksManager.setAvailibityBook(bookName, false);
    }

    public boolean returnBook(String bookName) {
        return this.booksManager.setAvailibityBook(bookName, true);
    }

}
