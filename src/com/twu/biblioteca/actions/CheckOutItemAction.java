package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

public class CheckOutItemAction implements Action {

    private ItemsManager itemsManager;

    @Override
    public String getName() {
        return "Checkout Item";
    }

    @Override
    public void execute(ItemsManager itemsManager, User userAction) {
        initializeBooksManager(itemsManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        checkOutBook(userInput, userAction);
    }

    public void initializeBooksManager(ItemsManager itemsManager) {
        this.itemsManager = itemsManager;
    }

    public void checkOutBook(String bookName, User checkOutUser) {
        if (!this.itemsManager.existItem(bookName)) {
            BibliotecaUI.informAboutTheBookNonEsxistence(bookName);
            return;
        }

        Item objectiveBook = this.itemsManager.getItem(bookName);

        if (!objectiveBook.isAvailable()) {
            System.out.println("\nThe book " + bookName + " is already checked out\n");
        } else {
            this.itemsManager.checkOutItem(bookName, checkOutUser);
            System.out.println("\nThe book " + bookName + " was successfully checked out\n");
        }
    }
}
