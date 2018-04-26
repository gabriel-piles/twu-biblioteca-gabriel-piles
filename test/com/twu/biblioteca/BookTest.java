package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void setAvailabilityToBook() {
        Book book = new Book("", "", 0, false);


        assertEquals(false, book.setAvailability(false));
        assertEquals(true, book.setAvailability(true));

        book = new Book("", "", 0, true);


        assertEquals(false, book.setAvailability(true));
        assertEquals(true, book.setAvailability(false));
    }

    @Test
    public void isAvailable() {
        Book book = new Book("", "", 0, false);
        assertEquals(false, book.isAvailable());

        book = new Book("", "", 0, true);
        assertEquals(true, book.isAvailable());
    }
}
