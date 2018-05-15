package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BooksManager;

import java.util.List;

public class ListAvailableBooksAction implements Action {

    private BooksManager booksManager;

    @Override
    public String getName() {
        return "List Books";
    }

    @Override
    public void execute(BooksManager booksManager) {
        initializeBooksManager(booksManager);
        printAvailableBooks();
    }

    public void initializeBooksManager(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void printAvailableBooks() {

        List<Book> booksList = this.booksManager.getBooksThatSatisfyCondition(true);

        System.out.println("\nList of available books:\n");

        for(Book eachBook: booksList)
        {
            System.out.println("- " + eachBook.getName());
        }

        System.out.println();
    }
}
