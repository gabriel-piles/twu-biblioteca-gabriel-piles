package com.twu.biblioteca.actions;


import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CheckOutBookActionTest {

    @Test
    public void getName() {
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction();
        assertEquals("Checkout Book", checkOutBookAction.getName());
    }

    @Test
    public void checkOutBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction();

        checkOutBookAction.initializeBooksManager(new BooksManager("test.txt"));

        checkOutBookAction.checkOutBook("first book");

        assertEquals("The book first book was successfully checked out", outputStream.toString().trim());
    }

    @Test
    public void checkOutBookFail() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction();

        checkOutBookAction.initializeBooksManager(new BooksManager("test.txt"));

        checkOutBookAction.checkOutBook("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());
    }


    @Test
    public void checkOutBookAlreadyCheckedOut() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction();

        checkOutBookAction.initializeBooksManager(new BooksManager("test.txt"));

        checkOutBookAction.checkOutBook("second book");

        assertEquals("The book second book is already checked out", outputStream.toString().trim());
        System.out.println("Something");
    }

    @Test
    public void userInputCheckOutBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutBookAction checkOutBookAction = new CheckOutBookAction();

        TestHelpers.userInput("first book");

        checkOutBookAction.execute(new BooksManager("test.txt"));

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("The book first book was successfully checked out"));
    }
}
