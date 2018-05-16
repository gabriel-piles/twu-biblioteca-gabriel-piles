package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import com.twu.biblioteca.UserTest;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ItemDetailsTest {

    @Test
    public void getName() {
        ItemDetailsAction bookDetails = new ItemDetailsAction();
        assertEquals("Item Details", bookDetails.getName());
    }

    @Test
    public void printItemDetailsFirstItem() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeItemsManager(ItemsManagerTest.initializeItemManagerForTesting());

        bookDetails.printItemDetails("first book", UserTest.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }

    @Test
    public void printItemDetailsSecondItem() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeItemsManager(ItemsManagerTest.initializeItemManagerForTesting());

        bookDetails.printItemDetails("second book", UserTest.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("second book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("2007"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("no"));
    }

    @Test
    public void printItemDetailsNonExistentItem() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();

        bookDetails.initializeItemsManager(ItemsManagerTest.initializeItemManagerForTesting());

        bookDetails.printItemDetails("third book", UserTest.getUserTest());

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());

    }

    @Test
    public void userInputReturnItemCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();
        bookDetails.initializeItemsManager(ItemsManagerTest.initializeItemManagerForTesting());

        TestHelpers.userInput("first book");

        bookDetails.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("Enter the book name:"));

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }

    @Test
    public void getUserCheckOutItem() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ItemDetailsAction bookDetails = new ItemDetailsAction();
        ItemsManager itemManager = ItemsManagerTest.initializeItemManagerForTesting();
        itemManager.checkOutItem("first book", UserTest.getAdminUserTest());

        TestHelpers.userInput("first book");

        bookDetails.execute(itemManager, UserTest.getAdminUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("Gabriel Piles"));
    }
}
