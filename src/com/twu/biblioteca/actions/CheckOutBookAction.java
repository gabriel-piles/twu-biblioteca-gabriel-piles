package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.User;

public class CheckOutBookAction implements Action {

    private BooksManager booksManager;

    @Override
    public String getName() {
        return "Checkout Book";
    }

    @Override
    public void execute(BooksManager booksManager, User userAction) {
        initializeBooksManager(booksManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        checkOutBook(userInput, userAction);
    }

    public void initializeBooksManager(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void checkOutBook(String bookName, User checkOutUser) {
        if (!this.booksManager.existBook(bookName)) {
            BibliotecaUI.informAboutTheBookNonEsxistence(bookName);
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        if (!objectiveBook.isAvailable()) {
            System.out.println("\nThe book " + bookName + " is already checked out\n");
        } else {
            this.booksManager.checkOutBook(bookName, checkOutUser);
            System.out.println("\nThe book " + bookName + " was successfully checked out\n");
        }
    }
}
