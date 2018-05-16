package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ListAvailableMoviesActionTest {

    @Test
    public void getName() {
        ListAvailableMoviesAction listAvailableBooks = new ListAvailableMoviesAction();
        assertEquals("List Movies", listAvailableBooks.getName());
    }

    @Test
    public void printAvailableMovies() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ListAvailableMoviesAction listAvailableMoviesAction = new ListAvailableMoviesAction();

        listAvailableMoviesAction.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("List of available movies:"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("first movie"));
    }
}
