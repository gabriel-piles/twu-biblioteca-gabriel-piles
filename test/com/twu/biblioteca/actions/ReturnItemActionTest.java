package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ReturnItemActionTest {

    @Test
    public void getName() {
        ReturnItemAction returnItemAction = new ReturnItemAction();
        assertEquals("Return Item", returnItemAction.getName());
    }

    @Test
    public void returnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnItemAction returnItemAction = new ReturnItemAction();

        returnItemAction.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        returnItemAction.returnBook("second book");

        assertEquals("The book second book was successfully returned", outputStream.toString().trim());
    }

    @Test
    public void returnBookInLibrary() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnItemAction returnItemAction = new ReturnItemAction();

        returnItemAction.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        returnItemAction.returnBook("first book");

        assertEquals("The book first book is not checked out", outputStream.toString().trim());
    }

    @Test
    public void returnBookFail() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnItemAction returnItemAction = new ReturnItemAction();

        returnItemAction.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        returnItemAction.returnBook("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());
    }

    @Test
    public void userInputReturnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ReturnItemAction returnItemAction = new ReturnItemAction();

        TestHelpers.userInput("second book");

        returnItemAction.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("The book second book was successfully returned"));
    }
}
