package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ListCheckOutItemsActionTest {

    @Test
    public void getName() {
        ListCheckoutItemsAction list = new ListCheckoutItemsAction();
        assertEquals("List Checkout Items", list.getName());
    }

    @Test
    public void printCheckOutItems() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        ListCheckoutItemsAction listCheckoutItems = new ListCheckoutItemsAction();

        listCheckoutItems.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());

        assertThat(outputStream.toString(), CoreMatchers.containsString("second book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("second movie"));
    }
}
