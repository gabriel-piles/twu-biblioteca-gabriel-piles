package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void get_options() {
        List<Option> menu = Menu.get_options();
        assertEquals(1, menu.get(0).getId);
        assertEquals("List Books", menu.get(0).getOption);
    }
}
