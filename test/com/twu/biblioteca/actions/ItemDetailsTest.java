package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ItemDetailsTest {

    @Test
    public void getName() {
        ItemDetailsAction bookDetails = new ItemDetailsAction();
        assertEquals("Book Details", bookDetails.getName());
    }

    @Test
    public void printBookDetailsFirstBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        bookDetails.printBookDetails("first book");

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }

    @Test
    public void printBookDetailsSecondBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        bookDetails.printBookDetails("second book");

        assertThat(outputStream.toString(), CoreMatchers.containsString("second book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("2007"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("no"));

    }

    @Test
    public void printBookDetailsNonExistentBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        bookDetails.printBookDetails("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());

    }

    @Test
    public void userInputReturnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        TestHelpers.userInput("first book");

        bookDetails.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }
}
