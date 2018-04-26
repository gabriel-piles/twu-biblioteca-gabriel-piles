package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MenuTest {

    @Test
    public void getOptions() {
        Map<String, String> menu = Menu.getMenu();

        assertNotEquals(null, menu);

        assertEquals("List Books", menu.get("1"));
        assertEquals("Book Details", menu.get("2"));
        assertEquals("Checkout Book", menu.get("3"));
        assertEquals("Return Book", menu.get("4"));
        assertEquals("Quit", menu.get("5"));
    }
}
