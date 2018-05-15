package com.twu.biblioteca.actions;


import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ReturnBookActionTest {

    @Test
    public void getName() {
        ReturnBookAction returnBookAction = new ReturnBookAction();
        assertEquals("Return Book", returnBookAction.getName());
    }

    @Test
    public void returnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnBookAction returnBookAction = new ReturnBookAction();

        returnBookAction.initializeBooksManager(new BooksManager("test.txt"));

        returnBookAction.returnBook("second book");

        assertEquals("The book second book was successfully returned", outputStream.toString().trim());
    }

    @Test
    public void returnBookInLibrary() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnBookAction returnBookAction = new ReturnBookAction();

        returnBookAction.initializeBooksManager(new BooksManager("test.txt"));

        returnBookAction.returnBook("first book");

        assertEquals("The book first book is not checked out", outputStream.toString().trim());
    }

    @Test
    public void returnBookFail() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnBookAction returnBookAction = new ReturnBookAction();

        returnBookAction.initializeBooksManager(new BooksManager("test.txt"));

        returnBookAction.returnBook("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());
    }

    @Test
    public void userInputReturnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnBookAction returnBookAction = new ReturnBookAction();

        TestHelpers.userInput("second book");

        returnBookAction.execute(new BooksManager("test.txt"));

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("The book second book was successfully returned"));
    }
}
