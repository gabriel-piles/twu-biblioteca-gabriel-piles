package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.UserTest;
import com.twu.biblioteca.UsersManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserDetailsTest {

    @Test
    public void getName() {
        UserDetailsAction userDetails = new UserDetailsAction();
        assertEquals("User Details", userDetails.getName());
    }

    @Test
    public void printBookDetailsFirstBook() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        UserDetailsAction userDetails = new UserDetailsAction();
        userDetails.execute(ItemsManagerTest.initializeItemManagerForTesting(), UserTest.getUserTest());

        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("111-111"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("Gabriel Piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("me@me.com"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("no"));

    }
}
