package com.twu.biblioteca.actions;


import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BookDetailsTest {

    @Test
    public void getName() {
        BookDetailsAction bookDetails = new BookDetailsAction();
        assertEquals("Book Details", bookDetails.getName());
    }

    @Test
    public void printBookDetailsFirstBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        BookDetailsAction bookDetails = new BookDetailsAction();

        bookDetails.initializeBooksManager(new BooksManager("test.txt"));

        bookDetails.printBookDetails("first book");

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }

    @Test
    public void printBookDetailsSecondBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        BookDetailsAction bookDetails = new BookDetailsAction();

        bookDetails.initializeBooksManager(new BooksManager("test.txt"));

        bookDetails.printBookDetails("second book");

        assertThat(outputStream.toString(), CoreMatchers.containsString("second book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("2007"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("no"));

    }

    @Test
    public void printBookDetailsNonExistentBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        BookDetailsAction bookDetails = new BookDetailsAction();

        bookDetails.initializeBooksManager(new BooksManager("test.txt"));

        bookDetails.printBookDetails("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());

    }

    @Test
    public void userInputReturnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        BookDetailsAction bookDetails = new BookDetailsAction();

        bookDetails.initializeBooksManager(new BooksManager("test.txt"));

        TestHelpers.userInput("first book");

        bookDetails.execute(new BooksManager("test.txt"), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }
}
