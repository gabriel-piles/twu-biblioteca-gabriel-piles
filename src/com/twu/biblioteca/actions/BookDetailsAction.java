package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BooksManager;

public class BookDetailsAction implements Action {

    private BooksManager booksManager;

    @Override
    public String getName() {
        return "Book Details";
    }

    @Override
    public void execute(BooksManager booksManager) {
        initializeBooksManager(booksManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        printBookDetails(userInput);
    }

    public void initializeBooksManager(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void printBookDetails(String bookName) {

        if(!this.booksManager.existBook(bookName))
        {
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        objectiveBook.printBookDetails();
    }
}
