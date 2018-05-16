package com.twu.biblioteca;


import com.twu.biblioteca.items.Item;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ItemsManagerTest {

    @Test
    public void getListOfItemsInitialize() {
        ItemsManager book_manager = initializeItemManagerForTesting();
        Map<String, Item> all_books = book_manager.getAllItems();
        assertEquals(all_books.size(), 4);
    }

    @Test
    public void getListOfItemsFirstItem() {
        ItemsManager itemsManager = initializeItemManagerForTesting();
        Map<String, Item> listOfItems = itemsManager.getAllItems();
        Item first_book = listOfItems.get("first book");
        // first book--gabriel piles--2009--yes
        assertEquals("first book", first_book.getId());
        assertEquals(true, first_book.isAvailable());
    }

    @Test
    public void getListOfItemsSecondItem() {
        ItemsManager itemsManager = initializeItemManagerForTesting();
        Map<String, Item> listOfItems = itemsManager.getAllItems();
        Item second_book = listOfItems.get("second book");
        // second book--gabriel piles--2007--no

    }

    @Test
    public void existItem() {
        ItemsManager itemsManager = initializeItemManagerForTesting();
        boolean exist = itemsManager.existItem("first book");
        assertEquals(true, exist);

        exist = itemsManager.existItem("second book");
        assertEquals(true, exist);

        exist = itemsManager.existItem("third book");
        assertEquals(false, exist);
    }

    @Test
    public void getItemFirstItem() {
        ItemsManager itemsManager = initializeItemManagerForTesting();
        Item first_book = itemsManager.getItem("first book");

        assertEquals("first book", first_book.getId());
        assertEquals(true, first_book.isAvailable());
    }

    @Test
    public void getItemSecondItem() {
        ItemsManager itemsManager = initializeItemManagerForTesting();
        Item second_book = itemsManager.getItem("second book");

        assertEquals("second book", second_book.getId());
        assertEquals(false, second_book.isAvailable());
    }

    @Test
    public void listAvailableBooks() {

        ItemsManager bookManager = initializeItemManagerForTesting();

        List<Item> listAvailableBooks = bookManager.listAvailableBooks();

        assertEquals(1, listAvailableBooks.size());

        Item first_book = listAvailableBooks.get(0);
        // first book--gabriel piles--2009--yes
        assertEquals("first book", first_book.getId());
    }

    @Test
    public void checkOutItemFail() {

        ItemsManager bookManager = initializeItemManagerForTesting();
        User newUser = new User("111-111","Gabriel Piles","me@me.com","651...","v",false);
        assertEquals(false, bookManager.checkOutItem("", newUser));
        assertEquals(false, bookManager.checkOutItem("second book", newUser));
    }

    @Test
    public void checkOutItem() {

        ItemsManager bookManager = initializeItemManagerForTesting();
        User newUser = new User("111-111","Gabriel Piles","me@me.com","651...","v",false);

        assertEquals(true, bookManager.checkOutItem("first book", newUser));
        List<Item> listAvailableBooks = bookManager.listAvailableBooks();

        assertEquals(0, listAvailableBooks.size());
    }

    @Test
    public void returnItemFail() {

        ItemsManager bookManager = initializeItemManagerForTesting();

        assertEquals(false, bookManager.returnItem(""));
        assertEquals(false, bookManager.returnItem("first book"));
    }

    @Test
    public void returnItem() {
        ItemsManager bookManager = initializeItemManagerForTesting();
        assertEquals(true, bookManager.returnItem("second book"));
        List<Item> listAvailableBooks = bookManager.listAvailableBooks();
        assertEquals(2, listAvailableBooks.size());
    }

    public static ItemsManager initializeItemManagerForTesting() {
        ItemsManager bookManager = new ItemsManager("books_test.txt", "movies_test.txt");
        return  bookManager;
    }
}
