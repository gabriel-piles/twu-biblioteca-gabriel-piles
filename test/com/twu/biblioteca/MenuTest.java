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
    public void getOptions() {
        Map<String, Action> menu = Menu.getMenu();

        assertNotEquals(null, menu);

        assertEquals("List Books", menu.get("1").getName());
        assertEquals("Book Details", menu.get("2").getName());
        assertEquals("Checkout Book", menu.get("3").getName());
        assertEquals("Return Book", menu.get("4").getName());
        assertEquals("Quit", menu.get("5").getName());
    }

    @Test
    public void createMenuEntryString() {
        assertEquals("13 List Books", Menu.createMenuEntryString("13", new ListAvailableBooksAction()));
    }
}
