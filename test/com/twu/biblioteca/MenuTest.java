package com.twu.biblioteca;


import com.twu.biblioteca.actions.Action;
import com.twu.biblioteca.actions.ListAvailableBooksAction;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MenuTest {


    @Test
    public void getMenu() {
        Map<String, Action> menu = Menu.getMenu();

        assertEquals("List Books", menu.get("1").getName());
        assertEquals("List Movies", menu.get("2").getName());
        assertEquals("List Checkout Items", menu.get("3").getName());
        assertEquals("Item Details", menu.get("4").getName());
        assertEquals("Checkout Item", menu.get("5").getName());
        assertEquals("Return Item", menu.get("6").getName());
        assertEquals("User Details", menu.get("7").getName());
        assertEquals("Quit", menu.get("8").getName());
    }

    @Test
    public void createMenuEntryString() {
        assertEquals("13 List Books", Menu.createMenuEntryString("13", new ListAvailableBooksAction()));
    }
}
