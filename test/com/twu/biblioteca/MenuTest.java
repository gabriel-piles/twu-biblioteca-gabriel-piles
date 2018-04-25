package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void getOptions() {
        List<Option> menu = Menu.getMenu();
        assertEquals(1, menu.get(0).getId());
        assertEquals("List Books", menu.get(0).getOption());

        assertEquals(2, menu.get(1).getId());
        assertEquals("Book Details", menu.get(1).getOption());

        assertEquals(3, menu.get(2).getId());
        assertEquals("Checkout Book", menu.get(2).getOption());

        assertEquals(4, menu.get(3).getId());
        assertEquals("Return Book", menu.get(3).getOption());

        assertEquals(5, menu.get(4).getId());
        assertEquals("Quit", menu.get(4).getOption());
    }
}
