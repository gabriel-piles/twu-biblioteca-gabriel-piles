package com.twu.biblioteca.actions;

import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

import java.util.List;

public class ListCheckoutItemsAction implements Action {

    private ItemsManager itemsManager;

    @Override
    public String getName() {
        return "List Checkout Items";
    }

    @Override
    public void execute(ItemsManager itemsManager, User user) {
        this.itemsManager = itemsManager;
        printCheckoutItems();
    }

    public void printCheckoutItems() {

        List<Item> itemsList = this.itemsManager.getItemsConditions(false, "all");

        System.out.println("\nList of checkout items:\n");

        for(Item eachItem: itemsList)
        {
            System.out.println(eachItem.getId() + " - " + eachItem.getName());
        }

        System.out.println();
    }
}
