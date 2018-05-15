package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.User;

public class ReturnBookAction implements Action {

    private BooksManager booksManager;

    @Override
    public String getName() {
        return "Return Book";
    }

    @Override
    public void execute(BooksManager booksManager, User user) {
        initializeBooksManager(booksManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        returnBook(userInput);
    }

    public void initializeBooksManager(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void returnBook(String bookName) {
        if (!this.booksManager.existBook(bookName)) {
            BibliotecaUI.informAboutTheBookNonEsxistence(bookName);
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        if (objectiveBook.isAvailable()) {
            System.out.println("\nThe book " + bookName + " is not checked out\n");
        } else {
            this.booksManager.returnBook(bookName);
            System.out.println("\nThe book " + bookName + " was successfully returned\n");
        }
    }
}
