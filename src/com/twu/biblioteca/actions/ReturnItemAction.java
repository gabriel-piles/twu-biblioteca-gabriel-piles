package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

public class ReturnItemAction implements Action {

    private ItemsManager itemsManager;

    @Override
    public String getName() {
        return "Return Item";
    }

    @Override
    public void execute(ItemsManager itemsManager, User user) {
        initializeBooksManager(itemsManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        returnBook(userInput);
    }

    public void initializeBooksManager(ItemsManager itemsManager) {
        this.itemsManager = itemsManager;
    }

    public void returnBook(String bookName) {
        if (!this.itemsManager.existItem(bookName)) {
            BibliotecaUI.informAboutTheBookNonEsxistence(bookName);
            return;
        }

        Item objectiveBook = this.itemsManager.getItem(bookName);

        if (objectiveBook.isAvailable()) {
            System.out.println("\nThe book " + bookName + " is not checked out\n");
        } else {
            this.itemsManager.returnItem(bookName);
            System.out.println("\nThe book " + bookName + " was successfully returned\n");
        }
    }
}
