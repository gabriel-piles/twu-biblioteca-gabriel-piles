package com.twu.biblioteca.actions;


import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ListAvailableBooksActionTest {

    @Test
    public void getName() {
        ListAvailableBooksAction listAvailableBooks = new ListAvailableBooksAction();
        assertEquals("List Books", listAvailableBooks.getName());
    }

    @Test
    public void printAvailableBooks() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ListAvailableBooksAction listAvailableBooks = new ListAvailableBooksAction();

        listAvailableBooks.execute(new BooksManager("test.txt"), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("List of available books:"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
    }
}
