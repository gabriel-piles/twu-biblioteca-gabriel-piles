package com.twu.biblioteca.actions;

import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

import java.util.List;

public class ListAvailableBooksAction implements Action {

    private ItemsManager itemsManager;

    @Override
    public String getName() {
        return "List Books";
    }

    @Override
    public void execute(ItemsManager itemsManager, User user) {
        initializeBooksManager(itemsManager);
        printAvailableBooks();
    }

    public void initializeBooksManager(ItemsManager itemsManager) {
        this.itemsManager = itemsManager;
    }

    public void printAvailableBooks() {

        List<Item> booksList = this.itemsManager.getItemsConditions(true, "book");

        System.out.println("\nList of available books:\n");

        for(Item eachItem: booksList)
        {
            System.out.println(eachItem.getId() + " - " + eachItem.getName());
        }

        System.out.println();
    }
}
