package com.twu.biblioteca;


import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void printUsers() {

        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        User newUser = new User("111-111","Gabriel Piles","me@me.com","651...","v",false);
        newUser.printUserDetails();
        assertThat(outputStream.toString(), CoreMatchers.containsString("111-111"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("Gabriel Piles"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("me@me.com"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("651..."));
        assertThat(outputStream.toString(), CoreMatchers.containsString("no"));
    }

    @Test
    public void checkPasswordCorrect() {
        User newUser = new User("111-111","Gabriel Piles","me@me.com","651...","v",false);
        assertTrue(newUser.checkPassword("v"));
    }

    @Test
    public void checkPasswordIncorrect() {
        User newUser = new User("111-111","Gabriel Piles","me@me.com","651...","v",false);
        assertTrue(!newUser.checkPassword("a"));
    }
}
