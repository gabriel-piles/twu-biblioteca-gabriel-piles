package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CheckOutItemActionTest {

    @Test
    public void getName() {
        CheckOutItemAction checkOutItemAction = new CheckOutItemAction();
        assertEquals("Checkout Item", checkOutItemAction.getName());
    }

    @Test
    public void usersNull() {
        ItemsManager bookManager = ItemsManagerTest.initializeItemManagerForTesting();
        assertEquals(null, bookManager.getItem("first book").getCheckOutUser());
        assertEquals(null, bookManager.getItem("second book").getCheckOutUser());
    }

    @Test
    public void checkOutBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutItemAction checkOutItemAction = new CheckOutItemAction();

        ItemsManager bookManager = ItemsManagerTest.initializeItemManagerForTesting();

        checkOutItemAction.initializeBooksManager(bookManager);

        checkOutItemAction.checkOutBook("first book", TestHelpers.getUserTest());

        assertEquals("The book first book was successfully checked out", outputStream.toString().trim());
        assertEquals("000-001", bookManager.getItem("first book").getCheckOutUser().getId());
    }

    @Test
    public void checkOutBookFail() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutItemAction checkOutItemAction = new CheckOutItemAction();

        checkOutItemAction.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        checkOutItemAction.checkOutBook("third book", TestHelpers.getUserTest());

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());
    }


    @Test
    public void checkOutBookAlreadyCheckedOut() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutItemAction checkOutItemAction = new CheckOutItemAction();

        checkOutItemAction.initializeBooksManager(ItemsManagerTest.initializeItemManagerForTesting());

        checkOutItemAction.checkOutBook("second book", TestHelpers.getUserTest());

        assertEquals("The book second book is already checked out", outputStream.toString().trim());
        System.out.println("Something");
    }

    @Test
    public void userInputCheckOutBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        CheckOutItemAction checkOutItemAction = new CheckOutItemAction();

        TestHelpers.userInput("first book");

        checkOutItemAction.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("The book first book was successfully checked out"));
    }
}
