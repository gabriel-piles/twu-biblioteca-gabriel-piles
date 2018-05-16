package com.twu.biblioteca.actions;

import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

import java.util.List;

public class ListAvailableMoviesAction implements Action {

    private ItemsManager itemsManager;

    @Override
    public String getName() {
        return "List Movies";
    }

    @Override
    public void execute(ItemsManager itemsManager, User user) {
        initializeBooksManager(itemsManager);
        printAvailableMovies();
    }

    public void initializeBooksManager(ItemsManager itemsManager) {
        this.itemsManager = itemsManager;
    }

    public void printAvailableMovies() {

        List<Item> booksList = this.itemsManager.getItemsConditions(true, "movie");

        System.out.println("\nList of available movies:\n");

        for(Item eachItem: booksList)
        {
            System.out.println(eachItem.getId() + " - " + eachItem.getName());
        }

        System.out.println();
    }
}
