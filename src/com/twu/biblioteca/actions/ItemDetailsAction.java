package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

public class ItemDetailsAction implements Action {

    private ItemsManager itemsManager;

    @Override
    public String getName() {
        return "Book Details";
    }

    @Override
    public void execute(ItemsManager itemsManager, User user) {
        initializeBooksManager(itemsManager);
        String userInput = BibliotecaUI.getUserInput("Enter the book name:");
        printBookDetails(userInput);
    }

    public void initializeBooksManager(ItemsManager itemsManager) {
        this.itemsManager = itemsManager;
    }

    public void printBookDetails(String bookName) {

        if(!this.itemsManager.existItem(bookName))
        {
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
            return;
        }

        Item objectiveBook = this.itemsManager.getItem(bookName);

        objectiveBook.printDetails();
    }
}
