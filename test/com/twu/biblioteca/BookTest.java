package com.twu.biblioteca;


import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookTest {

    @Test
    public void checkOutBook() {
        Book book = new Book("", "", 0, true);
        assertEquals(true, book.isAvailable());
        book.checkOut(TestHelpers.getUserTest());
        assertEquals(false, book.isAvailable());
    }

    @Test
    public void returnBook() {
        Book book = new Book("", "", 0, false);
        assertEquals(false, book.isAvailable());
        book.returnBook();
        assertEquals(true, book.isAvailable());
    }

    @Test
    public void getCheckOutUser() {
        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        Book book = new Book("first", "me", 2000, true);
        User newUser = TestHelpers.getUserTest();
        book.checkOut(newUser);
        book.getCheckOutUser().printUserDetails();
        assertThat(outputStream.toString(), CoreMatchers.containsString("111-111"));
    }

    @Test
    public void printBookDetails() {
        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        Book book = new Book("first", "me", 2000, false);
        book.printBookDetails();
        assertThat(outputStream.toString(), CoreMatchers.containsString("first"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("2000"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("me"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("no"));
    }
}
