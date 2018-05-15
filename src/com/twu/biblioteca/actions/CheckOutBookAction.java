package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BooksManager;

public class CheckOutBookAction implements Action {

    private BooksManager booksManager;

    @Override
    public String getName() {
        return "Checkout Book";
    }

    @Override
    public void execute(BooksManager booksManager) {
        initializeBooksManager(booksManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        checkOutBook(userInput);
    }

    public void initializeBooksManager(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void checkOutBook(String bookName) {
        if (!this.booksManager.existBook(bookName)) {
            BibliotecaUI.informAboutTheBookNonEsxistence(bookName);
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        if (!objectiveBook.isAvailable()) {
            System.out.println("\nThe book " + bookName + " is already checked out\n");
        } else {
            this.booksManager.checkOutBook(bookName);
            System.out.println("\nThe book " + bookName + " was successfully checked out\n");
        }
    }
}
